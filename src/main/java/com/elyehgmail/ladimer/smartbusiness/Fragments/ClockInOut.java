package com.elyehgmail.ladimer.smartbusiness.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.elyehgmail.ladimer.smartbusiness.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClockInOut.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ClockInOut#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClockInOut extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button enter, clockin,clockout,mealin,mealout;
    LinearLayout topLinear, bottomLinear;

    private OnFragmentInteractionListener mListener;

    public ClockInOut() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClockInOut.
     */
    // TODO: Rename and change types and number of parameters
    public static ClockInOut newInstance(String param1, String param2) {
        ClockInOut fragment = new ClockInOut();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_clock_in_out, container, false);


        enter = (Button)rootView.findViewById(R.id.enter);
        topLinear = (LinearLayout)rootView.findViewById(R.id.topLinear);
        bottomLinear = (LinearLayout) rootView.findViewById(R.id.bottomLinear);
        mealin = (Button)rootView.findViewById(R.id.mealin);
        mealout = (Button)rootView.findViewById(R.id.mealout);
        clockin = (Button)rootView.findViewById(R.id.clockin);
        clockout = (Button)rootView.findViewById(R.id.clockout);

        clockout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomLinear.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Thank you!  Enjoy the rest of your day.",
                        Toast.LENGTH_LONG).show();
            }
        });

        clockin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomLinear.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Welcome!",
                        Toast.LENGTH_LONG).show();
            }
        });
        mealin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomLinear.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Welcome back.",
                        Toast.LENGTH_LONG).show();
            }
        });

        mealout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomLinear.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Enjoy your meal.",
                        Toast.LENGTH_LONG).show();
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

               //topLinear.setVisibility(View.INVISIBLE);
                bottomLinear.setVisibility(View.VISIBLE);
            }
        });

        return rootView;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
