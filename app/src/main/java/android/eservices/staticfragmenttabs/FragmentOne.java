package android.eservices.staticfragmenttabs;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//TODO : fix this fragment so it works :)
//Once it's done, then create a second fragment with the other layout
public class FragmentOne extends Fragment {

    public static final String TAB_NAME = "ADD TO COUNTER";
    private View view;
    private MonInterface countInterface;
    private MainActivity act;

    public FragmentOne() {
    }

    public static FragmentOne newInstance() {
        FragmentOne fragmentOne = new FragmentOne();
        return fragmentOne;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one,container,false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {

        super.onStart();
        listenerButton1();
    }

    //TODO add listener to button and transmit the information to parent Activity
    public void listenerButton1(){
        Button plusBtn = view.findViewById(R.id.button_increment);
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countInterface != null){
                    countInterface.plus();
                }
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MonInterface){
            this.countInterface = (MonInterface) context;
        }
    }
    //TODO read the Android doc, as suggested, to do it the right way
}
