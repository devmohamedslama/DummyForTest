package onesource.shiftdigitalsolutions.dummyfortest.data.remote;

import java.util.concurrent.TimeUnit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final ConnectionPool CONNECTION_POOL = new ConnectionPool(0, 5, TimeUnit.MINUTES);
    private static final String BASE_URL = "http://192.168.1.19:3001/market/";

    public static ConfiguratorEndpoints getRetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        return retrofit.create(ConfiguratorEndpoints.class);
    }

    private static synchronized OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder().addInterceptor(chain -> {
                    Request newRequest = chain.request().newBuilder()
                            .build();
                    return chain.proceed(newRequest);
                })
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectionPool(CONNECTION_POOL)
//                .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }
}
