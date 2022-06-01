package onesource.shiftdigitalsolutions.dummyfortest.data.repo;

import android.util.Log;

import io.reactivex.rxjava3.core.Observable;

import io.reactivex.rxjava3.core.Single;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.QrcodeConfigurationResponse;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.UserDataEntity;
import onesource.shiftdigitalsolutions.dummyfortest.data.remote.RetrofitClient;


public class ConfigurationsRepo {

    public Single<QrcodeConfigurationResponse> getConfigurations(UserDataEntity userData) {
        try {
            return RetrofitClient.getRetrofitClient().sendConfigurations(userData);
        } catch (Exception e) {
            Log.d("SalamaTag", e.getMessage());
            return Single.error(new Exception("No Data"));
        }
    }
}
