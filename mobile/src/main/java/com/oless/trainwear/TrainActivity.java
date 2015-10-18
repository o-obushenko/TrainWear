package com.oless.trainwear;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.oless.trainwear.fragment.RouteListFragment;
import com.oless.trainwear.fragment.StopListFragment;

public class TrainActivity extends FragmentActivity {

    RouteListFragment mRouteListFragment;
    StopListFragment mStopListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRouteListFragment = RouteListFragment.newInstance();

        getFragmentManager().beginTransaction().add(R.id.contentPanel, mRouteListFragment, "route_list").addToBackStack("route_list").commit();
        getFragmentManager().executePendingTransactions();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void switchToStopList(String lineColor) {
        mStopListFragment = StopListFragment.newInstance();
        mStopListFragment.addArguments(lineColor);
        getFragmentManager().beginTransaction().add(R.id.contentPanel, mStopListFragment, "stop_list").addToBackStack("stop-list").commit();
        getFragmentManager().executePendingTransactions();
    }
}
