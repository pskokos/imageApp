package com.example.imageapp;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;

public class MainActivity extends Activity {


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// ActionBar/ shows the tabs
		ActionBar actionbar = getActionBar();
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// create new tabs and titles
		ActionBar.Tab cage = actionbar.newTab().setText("cage");
		ActionBar.Tab rage = actionbar.newTab().setText("Rage");
		ActionBar.Tab nickCage = actionbar.newTab().setText("Nick Cage");

		//create fragments
		Fragment FragOne = new TabFragmentOne();
		Fragment FragTwo = new TabFragmentTwo();
		Fragment FragThree = new TabFragmentThree();

		//puts the fragments to the bar
		cage.setTabListener(new MyTabsListener(FragOne,
				getApplicationContext()));
		rage.setTabListener(new MyTabsListener(FragTwo,
				getApplicationContext()));
		nickCage.setTabListener(new MyTabsListener(FragThree,
				getApplicationContext()));
		
		// add the tabs to actbar
		actionbar.addTab(cage);
		actionbar.addTab(rage);
		actionbar.addTab(nickCage);

	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

	}

}
//a private class to put the fragments into the tablistener
class MyTabsListener implements ActionBar.TabListener {
	public Fragment fragment;
	public Context context;

	public MyTabsListener(Fragment fragment, Context context) {
		this.fragment = fragment;
		this.context = context;

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		ft.replace(R.id.fragment_container, fragment);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.remove(fragment);
	}

}