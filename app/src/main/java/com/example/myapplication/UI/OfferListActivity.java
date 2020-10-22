package com.example.myapplication.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.ViewModel.OfferViewModel;
import com.example.myapplication.remote.responseModel.Offers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfferListActivity extends AppCompatActivity {
    private LayoutInflater layoutInflater;
    private List<Map<String, String>> data = new ArrayList<Map<String, String>>();
    private OfferViewModel vw;
    protected static final String ROW_TEXT = "OFFER_TITLE";
    protected static final String ROW_IMAGE = "OFFER_IMAGE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vw = new ViewModelProvider(this).get(OfferViewModel.class);
        setContentView(R.layout.list_activity);
      /*  Bundle bundle = getIntent().getExtras();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("appid", bundle.getString("appId"));
        parameters.put("uid", bundle.getString("uid"));
        parameters.put("hashkey", bundle.getString("hashkey"));
        //populateData(parameters);
        */

        populateData();
        ListView listView = (ListView) findViewById(R.id.list);

        layoutInflater = getLayoutInflater();
        String[] from = new String[]{ROW_TEXT, ROW_IMAGE};
        int[] to = new int[]{R.id.offerTitle, R.id.offerImage};

        // Create the adapter for the list.
        ListAdapter adapter = new ListAdapter(from, to);

        // Set the data to the list.
        listView.setAdapter(adapter);
    }

  /*  private void populateData(Map<String, String> parameters) {
        List<Offers> offerList = vw.getOfferList(parameters);
        for (int i = 0; i < offerList.size(); i++) {
            Map<String, String> item = new HashMap<>();
            item.put("title", offerList.get(i).getTitle());
            item.put("image", offerList.get(i).getThumbnail().getLowres());
            data.add(item);
        }
    }*/
    private void populateData() {
        //List<Offers> offerList = vw.getOfferList(parameters);
        for (int i = 0; i < 40; i++) {
            Map<String, String> item = new HashMap<>();
            item.put("title", "Offer Title "+String.valueOf(i));
            //item.put("image", offerList.get(i).getThumbnail().getLowres());
            data.add(item);
        }
    }
    private class ListAdapter extends SimpleAdapter {
        private List<Map<String, String>> offerData = new ArrayList<Map<String, String>>();
        public ListAdapter(String[] from, int[] to) {
            super(OfferListActivity.this, OfferListActivity.this.data, R.layout.list_item, from, to);
            offerData = OfferListActivity.this.data;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View view=super.getView(position, convertView, parent);
            TextView offerTitle=(TextView) view.findViewById(R.id.offerTitle);
            String title = offerData.get(position).toString();
            offerTitle.setText(title);

            offerTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    offerTitle.setText(String.valueOf(position));
                }
            });

            return view;
        }
    }
}
