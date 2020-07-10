package com.example.otrstattelecom.model.api;

import com.example.otrstattelecom.model.response.Message;
import com.example.otrstattelecom.model.request.MessageModelRequest;
import com.example.otrstattelecom.model.request.RequestCloseTicketModel;
import com.example.otrstattelecom.model.request.RequestData;
import com.example.otrstattelecom.model.request.RequestLockTicketModel;
import com.example.otrstattelecom.model.request.RequestTicketIds;
import com.example.otrstattelecom.model.response.SessionData;
import com.example.otrstattelecom.model.response.TicketIDs;
import com.example.otrstattelecom.model.response.TicketsModel;
import com.example.otrstattelecom.model.response.Token;
import com.example.otrstattelecom.model.response.TokenPush;

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


    @GET("api/new")
    Call<TokenPush> setToken(@Query("token") String tokeb,
                             @Query("idUser") String idUser
    );

    @POST("otrs/nph-genericinterface.pl/Webservice/to-otrs/search")
    Call<TicketIDs> getTicketIDs(@Body RequestTicketIds requestTicketIds
                                 );

    @POST("otrs/nph-genericinterface.pl/Webservice/to-otrs/GET_S")
    Call<TicketsModel> getTickets(@Body RequestData request
    );

    @POST("otrs/nph-genericinterface.pl/Webservice/to-otrs/UPD")
    Call<Message> setMessage(@Body MessageModelRequest request
    );

    @POST("otrs/nph-genericinterface.pl/Webservice/to-otrs/UPD")
    Call<Message> closeTask(@Body RequestCloseTicketModel requestClose
                               );
    @POST("otrs/nph-genericinterface.pl/Webservice/to-otrs/UPD")
    Call<Message> lockTask(@Body RequestLockTicketModel requestLockTicketModel);

    @GET("otrs/nph-genericinterface.pl/Webservice/to-otrs/Sget")
    Call<SessionData> getUserId(@Query("SessionID") String session);





}
