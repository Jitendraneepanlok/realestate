package com.tutorial.realestate.NavigationActivity.ui.quicklinks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.tutorial.realestate.NavigationActivity.ui.settings.SeetingModel;
import com.tutorial.realestate.R;

public class QuickLinkFragment extends Fragment {
    QuickLinkModel quickLinkModel;
    View view;
    String faqlink = "https://realestate.10to100.com/faqs";
    String newslink = "https://realestate.10to100.com/news";
    String termsconditionlink = "https://realestate.10to100.com/terms-conditions";
    String aboutuslink = "https://realestate.10to100.com/about-us";
    String privcypolicylink = "https://realestate.10to100.com/privacy-policy";
    String refundpolicylink = "https://realestate.10to100.com/refund-policy";
    CardView cardfaq,cardnews,cardtermscondition,cardaboutus,cardpolicy,cardrefund;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        quickLinkModel = ViewModelProviders.of(this).get(QuickLinkModel.class);

        view = inflater.inflate(R.layout.fragment_quick_links,container,false);
        /* final TextView textView = root.findViewById(R.id.text_slideshow);
        quickLinkModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        initView();
        return view;
    }

    private void initView() {
        cardfaq = (CardView)view.findViewById(R.id.cardfaq);
        cardfaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(faqlink));
                startActivity(intent);
            }
        });

        cardnews = (CardView)view.findViewById(R.id.cardnews);
        cardnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(newslink));
                startActivity(intent);
            }
        });

        cardtermscondition = (CardView)view.findViewById(R.id.cardtermscondition);
        cardtermscondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(termsconditionlink));
                startActivity(intent);
            }
        });

        cardaboutus = (CardView)view.findViewById(R.id.cardaboutus);
        cardaboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(aboutuslink));
                startActivity(intent);
            }
        });

        cardpolicy = (CardView)view.findViewById(R.id.cardpolicy);
        cardpolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(privcypolicylink));
                startActivity(intent);
            }
        });

        cardrefund = (CardView)view.findViewById(R.id.cardrefund);
        cardrefund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(refundpolicylink));
                startActivity(intent);
            }
        });
    }
}
