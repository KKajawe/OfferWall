package com.example.myapplication.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.other.QueryMapForOfferData;
import com.example.myapplication.remote.responseModel.OfferModel;
import com.example.myapplication.remote.responseModel.Offers;
import com.example.myapplication.repository.DefaultOfferRepository;

import java.util.List;
import java.util.Map;

import static com.example.myapplication.other.Util.validateQueryParams;

public class OfferViewModel extends ViewModel {
    private DefaultOfferRepository defaultOfferRepository;

    public OfferViewModel() {
        this.defaultOfferRepository = new DefaultOfferRepository();
    }

    private OfferModel getOfferData(Map<String, String> parameters) {
        return defaultOfferRepository.getOfferList(parameters);
    }

    public List<Offers> getOfferList(Map<String, String> userInputParams) {
        Map<String, String> params =new QueryMapForOfferData().getParameters(userInputParams);
        validateQueryParams(params);
        OfferModel offerModelResponse = getOfferData(params);
        return offerModelResponse.getOffersList();
    }


}
