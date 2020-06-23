package com.example.otrstattelecom.model.api;

import com.example.otrstattelecom.model.MessageDTO;
import com.example.otrstattelecom.model.MessageModelRequest;
import com.example.otrstattelecom.model.Request;
import com.example.otrstattelecom.model.RequestData;
import com.example.otrstattelecom.model.TicketIDs;
import com.example.otrstattelecom.model.TicketsModel;
import com.example.otrstattelecom.model.Token;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("otrs/nph-genericinterface.pl/Webservice/to-otrs/Screate?")
    Call<Token> requestLogin(@Query("UserLogin") String user,
                             @Query("Password") String password
    );

    @GET("otrs/nph-genericinterface.pl/Webservice/to-otrs/search?")
    Call<TicketIDs> getTicketIDs(@Query("SessionID") String session,
                                 @Query("TicketNumber") String TicketNumber
    );

    @POST("otrs/nph-genericinterface.pl/Webservice/to-otrs/GET_S")
    Call<TicketsModel> getTickets(@Body RequestData request
    );

    @POST("otrs/nph-genericinterface.pl/Webservice/to-otrs/UPD")
    Call<MessageDTO> setMessage(@Body MessageModelRequest request
    );



}
