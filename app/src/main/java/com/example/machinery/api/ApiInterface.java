package com.example.machinery.api;

import com.example.machinery.model.Department;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("save.php")
    Call<Department> saveNote(
        @Field("title") String title,
        @Field("note") String note,
        @Field("color") int color
    );

    @GET("getDepartment.php")
    Call<List<Department>> getDepartment();

    @FormUrlEncoded
    @POST("update.php")
    Call<Department> updateNote(
            @Field("id") int id,
            @Field("title") String title,
            @Field("note") String note,
            @Field("color") int color
    );

    @FormUrlEncoded
    @POST("delete.php")
    Call<Department> deleteNote(
            @Field("id") int id
    );
}
