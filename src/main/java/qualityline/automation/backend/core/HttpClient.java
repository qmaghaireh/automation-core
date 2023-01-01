package qualityline.automation.backend.core;

import okhttp3.OkHttpClient;
import qualityline.automation.utilities.helpers.ConfigKey;
import qualityline.automation.utilities.helpers.config.ProfilesConfigReader;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {

    private static HttpClient instance;
    private final Retrofit retrofit;

    private HttpClient(OkHttpClient client) {
        retrofit =
                new Retrofit.Builder()
                        .baseUrl(ProfilesConfigReader.getInstance().getPropValue(ConfigKey.BASE_URL))
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .build();
    }

    public static HttpClient getInstance(OkHttpClient client) {
        if (instance == null) {
            instance = new HttpClient(client);
        }
        return instance;
    }

    public <T> T create(Class<T> cls) {
        return retrofit.create(cls);
    }
}
