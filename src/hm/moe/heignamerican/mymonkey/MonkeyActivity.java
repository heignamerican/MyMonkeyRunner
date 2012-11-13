package hm.moe.heignamerican.mymonkey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MonkeyActivity extends Activity {
	static final String SARU = "saru";

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_monkey);

		final TableLayout tTable = (TableLayout) findViewById(R.id.main_table);
		final int tRowSize = 8;
		final int tColSize = 4;

		final StringBuilder tBuilder = new StringBuilder();

		int tNumber = 1;
		for (int tRow = 0; tRow < tRowSize; tRow++) {
			final TableRow tTableRow = new TableRow(this);

			for (int tCol = 0; tCol < tColSize; tCol++) {
				final int tId = tNumber++;

				final Button tButton = new Button(this);
				final String tText = String.format("さる%02d", tId);
				tButton.setText(tText);
				tButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(final View aView) {
						tBuilder.append(tText);
						final String tString = tBuilder.toString();
						Log.d(SARU, tString);

						if (tString.contains("さる01さる02")) {
							final Intent tIntent = new Intent();
							tIntent.setClass(MonkeyActivity.this, NextActivity.class);
							startActivity(tIntent);
							tBuilder.setLength(0);
						} else if (tString.contains("さる07さる03さる25")) {
							Log.d(SARU, "終了");
							finish();
						}
					}
				});

				tTableRow.addView(tButton);
			}
			tTable.addView(tTableRow);
		}
	}
}
