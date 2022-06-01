package onesource.shiftdigitalsolutions.dummyfortest.data.remote;

import io.reactivex.rxjava3.core.Single;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.QrcodeConfigurationResponse;
import onesource.shiftdigitalsolutions.dummyfortest.data.entity.UserDataEntity;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ConfiguratorEndpoints {

    @POST("reteriveAllLookupData")
    Single<QrcodeConfigurationResponse> sendConfigurations(@Body UserDataEntity userData);
}
