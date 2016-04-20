/***
ListViewDemo.java
*/

package com.dcp.android.selection;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class GCMenuProblem1 extends ListActivity {
	TextView selection;
	String[] items={"lorem", "ipsum", "dolor", "sit", "amet",
					"consectetuer", "adipiscing", "elit", "morbi", "vel",
					"ligula", "vitae", "arcu", "aliquet", "mollis",
					"etiam", "vel", "erat", "placerat", "ante",
					"porttitor", "sodales", "pellentesque", "augue", "purus"};

    public static final int ONE_PX = Menu.FIRST+1;
    public static final int TWO_PX = Menu.FIRST+2;
    public static final int EIGHT_PX = Menu.FIRST+3;
    public static final int SIXTEEN_PX = Menu.FIRST+4;
    public static final int TWENTY_FOUR_PX = Menu.FIRST+5;
    public static final int THIRTY_TWO_PX = Menu.FIRST+6;
    public static final int FORTY_PX = Menu.FIRST+7;

	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		setListAdapter(new ArrayAdapter<String>(this,
												android.R.layout.simple_list_item_1,
												items));
		selection=(TextView)findViewById(R.id.selection);
		registerForContextMenu(getListView());
	}
	
	public void onListItemClick(ListView parent, View v, int position,
																long id) {
	 	selection.setText(items[position]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		updateMenu(menu);
		return (super.onCreateOptionsMenu(menu));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return (menuChoice(item) || super.onOptionsItemSelected(item));
	}

	@Override
	public boolean onContextItemSelected(MenuItem item){
		return(menuChoice(item) || super.onContextItemSelected(item));
	}

	private void updateMenu(Menu menu){
		menu.add(Menu.NONE, ONE_PX, Menu.NONE, "1 Pixel");
		menu.add(Menu.NONE, TWO_PX, Menu.NONE, "2 Pixel");
		menu.add(Menu.NONE, EIGHT_PX, Menu.NONE, "8 Pixel");
		menu.add(Menu.NONE, SIXTEEN_PX, Menu.NONE, "16 Pixel");
		menu.add(Menu.NONE, TWENTY_FOUR_PX, Menu.NONE, "24 Pixel");
		menu.add(Menu.NONE, THIRTY_TWO_PX, Menu.NONE, "32 Pixel");
		menu.add(Menu.NONE, FORTY_PX, Menu.NONE, "40 Pixel");
	}

	private boolean menuChoice (MenuItem item) {
		switch(item.getItemId()) {
			case ONE_PX:
				getListView().setDividerHeight(1);
				return(true);

			case TWO_PX:
				getListView().setDividerHeight(2);
				return(true);

			case EIGHT_PX:
				getListView().setDividerHeight(8);
				return(true);

			case SIXTEEN_PX:
				getListView().setDividerHeight(16);
				return(true);

			case TWENTY_FOUR_PX:
				getListView().setDividerHeight(24);
				return(true);

			case THIRTY_TWO_PX:
				getListView().setDividerHeight(32);
				return(true);

			case FORTY_PX:
				getListView().setDividerHeight(40);
				return(true);
		}

		return(false);
	}
}