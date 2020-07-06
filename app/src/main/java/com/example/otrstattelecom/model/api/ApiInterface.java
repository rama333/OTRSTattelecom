package com.example.otrstattelecom.model.api;

import com.example.otrstattelecom.model.MessageDTO;
import com.example.otrstattelecom.model.MessageModelRequest;
import com.example.otrstattelecom.model.RequestCloseTicketModel;
import com.example.otrstattelecom.model.RequestData;
import com.example.otrstattelecom.model.RequestLockTicketModel;
import com.example.otrstattelecom.model.RequestTicketIds;
import com.example.otrstattelecom.model.SessionData;
import com.example.otrstattelecom.model.TicketIDs;
import com.example.otrstattelecom.model.TicketsModel;
import com.example.otrstattelecom.model.Token;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("otrs/nph-genericinterface.pl/Webservice/to-otrs/Screate?")
    Call<Token> requestLogin(@Query("UserLogin") String user,
                             @Query("Password") String password
    );

    @POST("otrs/nph-genericinterface.pl/Webservice/to-otrs/search")
    Call<TicketIDs> getTicketIDs(@Body RequestTicketIds requestTicketIds
                                 );

    @POST("otrs/nph-genericinterface.pl/Webservice/to-otrs/GET_S")
    Call<TicketsModel> getTickets(@Body RequestData request
    );

    @POST("otrs/nph-genericinterface.pl/Webservice/to-otrs/UPD")
    Call<MessageDTO> setMessage(@Body MessageModelRequest request
    );

    @POST("otrs/nph-genericinterface.pl/Webservice/to-otrs/UPD")
    Call<MessageDTO> closeTask(@Body RequestCloseTicketModel requestClose
                               );
    @POST("otrs/nph-genericinterface.pl/Webservice/to-otrs/UPD")
    Call<MessageDTO> lockTask(@Body RequestLockTicketModel requestLockTicketModel);

    @GET("otrs/nph-genericinterface.pl/Webservice/to-otrs/Sget")
    Call<SessionData> getUserId(@Query("SessionID") String session);





}
