package com.simulator.credit.integration.mocky.service;

import com.google.gson.Gson;
import com.simulator.credit.domain.constant.Constant;
import com.simulator.credit.domain.errors.BaseException;
import com.simulator.credit.integration.mocky.dto.MockyVehicleLoanRespDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class MockyIntegrationService {

    public MockyVehicleLoanRespDto postMockyVehicleLoan() {

        MockyVehicleLoanRespDto mockyVehicleLoanRespDto;
        try {
            var okHttpClient = new OkHttpClient();

            var request = new Request.Builder()
                    .url(Constant.BASE_URL_MOCKY + "28c1d4c7-a5e6-41f9-b754-76f8122d9304")
                    .build();

            System.out.println("Integrations to url "
                    + Constant.BASE_URL_MOCKY + "28c1d4c7-a5e6-41f9-b754-76f8122d9304");
            var response = okHttpClient.newCall(request).execute();
            if(response == null) {
                throw new BaseException("response null");
            } else {
                System.out.println("integrations success");
            }
            mockyVehicleLoanRespDto =
                    new Gson().fromJson(response.body().string(), MockyVehicleLoanRespDto.class);
        } catch (IOException ioe) {
            throw new BaseException("io exception. integration to mocky vehicle loan error " + ioe.getMessage());
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }

        return mockyVehicleLoanRespDto;
    }

}
