package iamrishav.com.example.collapselayout;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements Preview.PreviewListener {
    EditText mInputLink;
    Button mBtnPreview;
    Preview mPreview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInputLink=(EditText)findViewById(R.id.inputLink);
        mBtnPreview=(Button)findViewById(R.id.btnPreview);
        mPreview=(Preview)findViewById(R.id.preview);
        mPreview.setListener(this);
        if(mBtnPreview!=null)
            mBtnPreview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mInputLink!=null&&mInputLink.getText()!=null&&!mInputLink.getText().toString().equals(""))
                    {
                        mPreview.setData(mInputLink.getText().toString());
                    }
                }
            });
    }

    @Override
    public void onDataReady(Preview preview) {
        mPreview.setMessage(preview.getLink());
    }
}
