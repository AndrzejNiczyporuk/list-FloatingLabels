package pl.lo3.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/*
 * Very basic Activity, the only things it does
 * are get the ListView reference from our layout.
 * Create an Adapter, set the Adapter to the ListView
 * and handle the onItemClick events for when the user
 * clicks on a row.
 */
public class MainActivity extends AppCompatActivity {
	private Toolbar toolbar;
	CSVAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		//Lookup our ListView
		ListView mList = (ListView)findViewById(R.id.mList);
		
		//Create Adapter. The second parameter is required by ArrayAdapter
		//which our Adapter extends. In this example though it is unused,
		//so we'll pass it a "dummy" value of -1.
		mAdapter = new CSVAdapter(this, -1);
		
		//attach our Adapter to the ListView. This will populate all of the rows.
		mList.setAdapter(mAdapter);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
				Intent intent = new Intent(getApplicationContext(),ParameterActivity.class);
				startActivity(intent);

			}
		});
		
		
		/*
		 * This listener will get a callback whenever the user clicks on a row. 
		 * The pos parameter will tell us which row got clicked.
		 * 
		 * For now we'll just show a Toast with the state capital for the state that was clicked.
		 */
		mList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int pos,long id) {

				Intent intent = new Intent(getApplicationContext(),ParameterActivity.class);
				intent.putExtra("land",""+mAdapter.getItem(pos).getLand().trim());
                intent.putExtra("city",""+mAdapter.getItem(pos).getCity().trim());
				intent.putExtra("stop",""+mAdapter.getItem(pos).getStopNumber() + "-" +mAdapter.getItem(pos).getStopName().trim());
				intent.putExtra("line",""+mAdapter.getItem(pos).getLineNumber() + "-" +mAdapter.getItem(pos).getLineDirection().trim());
				intent.putExtra("from",""+mAdapter.getItem(pos).getFrom().getTime());
				intent.putExtra("down",""+mAdapter.getItem(pos).getDown().getTime());
				startActivity(intent);

				//Toast.makeText(v.getContext(), mAdapter.getItem(pos).getCity(), Toast.LENGTH_SHORT).show();

			}
		});
	}
}
