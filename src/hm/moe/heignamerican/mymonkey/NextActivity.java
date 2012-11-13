package hm.moe.heignamerican.mymonkey;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class NextActivity extends Activity {
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);

		final TableLayout tLayout = (TableLayout) findViewById(R.id.next_layout);

		final Button tButton1 = new Button(this);
		tButton1.setText("back");
		tButton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View aView) {
				NextActivity.this.finish();
				Log.d(MonkeyActivity.SARU, "とり back");
				return;
			}
		});
		final TableRow tTableRow1 = new TableRow(this);
		tTableRow1.addView(tButton1);
		tLayout.addView(tTableRow1);

		final int tRowSize = 4;
		final int tColSize = 4;

		final StringBuilder tBuilder = new StringBuilder();
		int tNumber = 2;
		for (int tRow = 0; tRow < tRowSize; tRow++) {
			final TableRow tTableRow = new TableRow(this);

			for (int tCol = 0; tCol < tColSize; tCol++) {
				final int tId = tNumber++;

				final Button tButton = new Button(this);
				final String tText = String.format("とり%02d", tId);
				tButton.setText(tText);
				tButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(final View aView) {
						tBuilder.append(tText);
						final String tString = tBuilder.toString();
						Log.d(MonkeyActivity.SARU, tString);

						if (tString.contains("とり14")) {
							throw new RuntimeException("ぎゃあああああああああああああああああああ");
						}
					}
				});

				tTableRow.addView(tButton);
			}
			tLayout.addView(tTableRow);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		getMenuInflater().inflate(R.menu.activity_next, menu);
		return true;
	}
}
