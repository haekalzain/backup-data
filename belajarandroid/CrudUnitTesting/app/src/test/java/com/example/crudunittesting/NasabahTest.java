package com.example.crudunittesting;

import com.example.crudunittesting.model.GetListNasabah;
import com.example.crudunittesting.model.Nasabah;
import com.example.crudunittesting.rest.ApiClient;
import com.example.crudunittesting.rest.ApiInterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class NasabahTest {
    private List<Nasabah> listNasabahTemp= new ArrayList<>();

   @Test
    public void get_list_nasabah(){
       final CountDownLatch latch = new CountDownLatch(1);
       listNasabahTemp.clear();
       ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
       Call<GetListNasabah> nasabahCall =mApiInterface.getListNasabah();
       nasabahCall.enqueue(new Callback<GetListNasabah>() {
           @Override
           public void onResponse(Call<GetListNasabah> call, Response<GetListNasabah> response) {
               if(response.isSuccessful()){
                   latch.countDown();
                   listNasabahTemp = response.body().getListNasabah();
                   System.out.println("Success"+String.valueOf(listNasabahTemp.size())+"Record");
                   assertThat(listNasabahTemp.size(),greaterThan(0));
                   String nameactual= listNasabahTemp.get(5).getNama();
                   String nameexpected ="ABUBBBBBBA";
                   String alamatactual=listNasabahTemp.get(5).getAlamat();
                   String alamatexpected="PADANGGGGG";
                   assertEquals("alamat kelima ga sesuai",alamatactual,alamatexpected);
                   assertEquals("Nama kelima ga sesuai",nameexpected,nameactual);
                   if (nameactual.equals(nameexpected)&&alamatactual.equals(alamatexpected)){
                       System.out.println("Tes Berhasil");
                   }else{
                       System.out.println("Data beda");

                   }
               }else{
                   System.out.println("Error");
                   latch.countDown();
                   assertThat(0,greaterThan(0));
               }
           }

           @Override
           public void onFailure(Call<GetListNasabah> call, Throwable t) {
               System.out.println("Failure");
               latch.countDown();
               assertThat(0,greaterThan(0));

           }
       });
       try {
           latch.await();
           assertThat(listNasabahTemp.size(),greaterThan(0));
       }
       catch (InterruptedException e){
           e.printStackTrace();
           assertThat(listNasabahTemp.size(),greaterThan(0));
       }
   }
}
