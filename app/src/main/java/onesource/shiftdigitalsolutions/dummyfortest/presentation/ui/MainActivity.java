package onesource.shiftdigitalsolutions.dummyfortest.presentation.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import onesource.shiftdigitalsolutions.dummyfortest.R;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.QrcodeConfigurationResponse;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.UserDataEntity;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.CategoryEntity;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.ClassificationEntity;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.DefinitionEntity;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.configurations.MarketsEntity;
import onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.category.CategoryDao;
import onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.category.CategoryDatabase;
import onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.classification.ClassificationDao;
import onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.classification.ClassificationDatabase;
import onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.definition.DefinitionDao;
import onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.definition.DefinitionDatabase;
import onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.market.MarketDao;
import onesource.shiftdigitalsolutions.dummyfortest.data.local.room.app.market.MarketDatabase;
import onesource.shiftdigitalsolutions.dummyfortest.data.repo.ConfigurationsRepo;
import onesource.shiftdigitalsolutions.dummyfortest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ConfigurationsRepo repo;

    MarketDao marketDao;
    CategoryDao categoryDao;
    ClassificationDao classificationDao;
    DefinitionDao definitionDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        init();
    }

    private void init() {
        repo = new ConfigurationsRepo();
        marketDao = MarketDatabase.getINSTANCE(this).marketDao();
        categoryDao = CategoryDatabase.getINSTANCE(this).categoryDao();
        classificationDao = ClassificationDatabase.getINSTANCE(this).classificationDao();
        definitionDao = DefinitionDatabase.getINSTANCE(this).definitionDao();
        action();
    }

    private void action() {
        binding.getDataBT.setOnClickListener(v -> {
            repo.getConfigurations(new UserDataEntity("DEVICE", "55555"))
                    .subscribeOn(Schedulers.io())
                    .subscribe(new SingleObserver<QrcodeConfigurationResponse>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {
                            Log.d("SalamaTag", "Subscribe");
                        }

                        @Override
                        public void onSuccess(@NonNull QrcodeConfigurationResponse qrcodeConfigurationResponse) {
                            Log.d("SalamaTag", "Success");
                            saveQrcodeConfigurationResponse(qrcodeConfigurationResponse);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            Log.d("SalamaTag", "Throwable: " + e.getMessage());
                        }
                    });
        });
        binding.getLocalDataBT.setOnClickListener(v -> loadData());
    }

    private void saveQrcodeConfigurationResponse(QrcodeConfigurationResponse qrcodeConfigurationResponse) {
        for (MarketsEntity marketsEntity : qrcodeConfigurationResponse.getConfigurationEntity().getMarketsEntityList())
            marketDao.insertMarketsEntity(marketsEntity).subscribeOn(Schedulers.trampoline()).subscribe();
        for (CategoryEntity categoryEntity : qrcodeConfigurationResponse.getConfigurationEntity().getCategoryEntityList())
            categoryDao.insertCategoryEntity(categoryEntity).subscribeOn(Schedulers.trampoline()).subscribe();
        for (ClassificationEntity classificationEntity : qrcodeConfigurationResponse.getConfigurationEntity().getClassificationEntityList())
            classificationDao.insertClassificationEntity(classificationEntity).subscribeOn(Schedulers.trampoline()).subscribe();
        for (DefinitionEntity definitionEntity : qrcodeConfigurationResponse.getConfigurationEntity().getDefinitionEntityList())
            definitionDao.insertDefinitionEntity(definitionEntity).subscribeOn(Schedulers.trampoline()).subscribe();

        Log.d("SalamaTag", "Done");
    }

    private void loadData() {
        getAllMarkets();
        getAllCategories();
        getAllClassificationsById(1);
        getAllDefinitionsById(1);
    }

    private void getAllMarkets() {
        marketDao.getAllMarketsEntity().subscribeOn(Schedulers.io()).subscribe(
                new SingleObserver<List<MarketsEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<MarketsEntity> marketsEntities) {
                        Log.d("SalamaTag", marketsEntities.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("SalamaTag", "market: " + e.getMessage());
                    }
                }
        );
    }

    private void getAllCategories() {
        categoryDao.getAllCategoryEntity().subscribeOn(Schedulers.io()).subscribe(
                new SingleObserver<List<CategoryEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<CategoryEntity> categoryEntityList) {
                        Log.d("SalamaTag", categoryEntityList.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("SalamaTag", "category: " + e.getMessage());
                    }
                }
        );
    }

    private void getAllClassificationsById(int id) {
        classificationDao.getClassificationEntityById(id).subscribeOn(Schedulers.io()).subscribe(
                new SingleObserver<List<ClassificationEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<ClassificationEntity> classificationEntities) {
                        Log.d("SalamaTag", classificationEntities.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("SalamaTag", "classification: " + e.getMessage());
                    }
                }
        );
    }

    private void getAllDefinitionsById(int id) {
        definitionDao.getDefinitionEntityById(id).subscribeOn(Schedulers.io()).subscribe(
                new SingleObserver<List<DefinitionEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull List<DefinitionEntity> definitionEntityList) {
                        Log.d("SalamaTag", definitionEntityList.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("SalamaTag", "definition: " + e.getMessage());
                    }
                }
        );
    }
}