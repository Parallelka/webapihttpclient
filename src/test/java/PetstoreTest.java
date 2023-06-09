import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.apache.hc.core5.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static org.testng.AssertJUnit.assertEquals;

public class PetstoreTest {
    public static final String BASE_URL = "https://petstore.swagger.io/v2";
    public static final String FIND_AVAILABLE = "/pet/findByStatus?status=available";
    public static final String PET_BY_WRONG_ID = "/pet/102q4";
    public static final String PET_BY_ID = "/pet/10";
    public static final String LOGIN_USER = "/user/login?username=test&password=abc123";

    @Test
    public void getAvailable() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_URL + FIND_AVAILABLE);
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpGet);
        assertEquals(SC_OK, httpResponse.getCode());
    }

    @Test
    public void getPetByWrongId() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_URL + PET_BY_WRONG_ID);
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpGet);
        assertEquals(SC_NOT_FOUND, httpResponse.getCode());
    }

    @Test
    public void getPetByID() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_URL + PET_BY_ID);
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpGet);
        assertEquals(SC_OK, httpResponse.getCode());
    }

    @Test
    public void getLoginUser() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_URL + LOGIN_USER);
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpGet);
        assertEquals(SC_OK, httpResponse.getCode());
    }

    @Test
    public void deletePetByWrongID() throws IOException {
        HttpDelete httpPost = new HttpDelete(BASE_URL + PET_BY_WRONG_ID);
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpPost);
        assertEquals(SC_NOT_FOUND, httpResponse.getCode());
    }
}
