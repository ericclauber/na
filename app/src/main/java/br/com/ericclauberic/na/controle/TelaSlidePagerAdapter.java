package br.com.ericclauberic.na.controle;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import br.com.ericclauberic.na.FragmentoSlideQuiz;

/**
 * Created by eric on 12/08/16.
 */
public class TelaSlidePagerAdapter extends FragmentStatePagerAdapter {


    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private Context context;
    public static  final int NUM_PAGES = 5;
    private int[] img;

    public TelaSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new FragmentoSlideQuiz();
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//
//        View view = LayoutInflater.from(this.context).inflate(R.layout.fragment_slide_quiz,container,false);
//        TextView textView = (TextView) view.findViewById(R.id.fragment_textview_questao);
//        textView.setText(img[position]);
//        return  view;
//        //return super.instantiateItem(container, position);
//    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
    }
}


