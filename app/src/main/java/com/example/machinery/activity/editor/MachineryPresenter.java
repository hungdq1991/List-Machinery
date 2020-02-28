package com.example.machinery.activity.editor;

public class MachineryPresenter {

    private MachineryView view;

    public MachineryPresenter(MachineryView view) {
        this.view = view;
    }

    void saveNote(final String title, final String note, final int color) {

        view.showProgress();

//        ApiInterface apiInterface = ApiClient.getApiClient().create( ApiInterface.class);
//        Call<Department> call = apiInterface.saveNote( title, note, color );
//
//        call.enqueue( new Callback<Department>() {
//            @Override
//            public void onResponse(@NonNull Call<Department> call, @NonNull Response<Department> response) {
//                view.hideProgress();
//
//                if (response.isSuccessful() && response.body() != null) {
//                    Boolean success = response.body().getSuccess();
//                    if (success) {
//                        view.onRequestSuccess( response.body().getMessage() );
//                    }
//                    else {
//                        view.onRequestError( response.body().getMessage() );
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<Department> call, @NonNull Throwable t) {
//                view.hideProgress();
//                view.onRequestError( t.getLocalizedMessage());
//            }
//        } );
    }

    void updateNote(int id, String title, String note, int color) {
        view.showProgress();
//        ApiInterface apiInterface = ApiClient.getApiClient().create( ApiInterface.class );
//
//        Call<Department> call = apiInterface.updateNote( id, title, note, color );
//        call.enqueue( new Callback<Department>() {
//            @Override
//            public void onResponse(Call<Department> call, Response<Department> response) {
//                view.hideProgress();
//                if (response.isSuccessful() && response.body() != null) {
//                    Boolean success = response.body().getSuccess();
//                    if (success) {
//                        view.onRequestSuccess( response.body().getMessage() );
//                    } else {
//                        view.onRequestError( response.body().getMessage() );
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Department> call, Throwable t) {
//
//            }
//        } );
    }

    void deleteNote(int id) {
        view.showProgress();
//        ApiInterface apiInterface = ApiClient.getApiClient().create( ApiInterface.class );
//        Call<Department> call = apiInterface.deleteNote( id );
//        call.enqueue( new Callback<Department>() {
//            @Override
//            public void onResponse(Call<Department> call, Response<Department> response) {
//                view.hideProgress();
//                if (response.isSuccessful() && response.body() != null) {
//                    Boolean success = response.body().getSuccess();
//                    if (success) {
//                        view.onRequestSuccess( response.body().getMessage() );
//                    } else {
//                        view.onRequestError( response.body().getMessage() );
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Department> call, Throwable t) {
//                view.hideProgress();
//                view.onRequestError( t.getLocalizedMessage() );
//            }
//        } );
    }
}
