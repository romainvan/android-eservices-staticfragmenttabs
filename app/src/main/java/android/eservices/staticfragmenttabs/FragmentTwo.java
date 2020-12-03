package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class FragmentTwo extends Fragment {

    public static final String TAB_NAME = "REMOVE TO COUNTER";
    private View view;
    private MonInterface countInterface;

    public FragmentTwo() {
    }

    public static FragmentTwo newInstance() {
        return new FragmentTwo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two,container,false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        listenerButton2();
    }

    //TODO add listener to button and transmit the information to parent Activity
    public void listenerButton2(){
        Button moinsBtn = view.findViewById(R.id.button_decrement);
        moinsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countInterface != null){
                    countInterface.moins();
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
