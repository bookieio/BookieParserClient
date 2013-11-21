package us.bmark.bookieParserClient.BookeParserService;

import org.junit.Before;
import org.junit.Test;

import retrofit.RestAdapter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookieParserServiceITCase {

    BookieParserService service;

    static final String SERVER_URL = "http://r.bmark.us";
    static final RestAdapter adapter = new RestAdapter.Builder()
            .setServer(SERVER_URL).build();


    @Before
    public void setService() {
        adapter.setLogLevel(RestAdapter.LogLevel.FULL);
        service = adapter.create(BookieParserService.class);
    }

    @Test
    public void openMetalCastEpisodeOne() {
        final String openMetalCast1Url
                = "https://archive.org/details/OpenMetalcastEpisode1OpenTheGates";
        ParseResponse response = service.parse(openMetalCast1Url);

        assertThat(response,is(notNullValue()));
        assertThat(response.readable,is(notNullValue()));
        assertThat(response.data,is(notNullValue()));
        final String openMetalCast1Title
                = "Open MetalCast Episode #1: Open the Gates"
                +" : Craig Maloney : Free Download & Streaming : Internet Archive";
        assertThat(response.data.title,
                is(equalTo(openMetalCast1Title)));

        assertThat(response.data.url,is(equalTo(openMetalCast1Url)));
    }

}
