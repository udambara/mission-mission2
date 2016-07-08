package com.example.android.ex2_readedit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {
    EditText etinput;
    TextView tvoutput;
    Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init(){
        etinput = (EditText)findViewById(R.id.et_input);
        tvoutput = (TextView)findViewById(R.id.tv_output);
        btnsave = (Button)findViewById(R.id.btn_save);

        etinput.setOnEditorActionListener(this);
    }

    public void onClickSave(View view){
        String input = etinput.getText().toString();
        tvoutput.setText(input);
        view = this.getCurrentFocus();

        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if(textView.getId()==R.id.et_input && i== EditorInfo.IME_ACTION_SEND){ // 뷰의 id를 식별, 키보드의 완료 키 입력 검출

            String input = etinput.getText().toString();
            tvoutput.setText(input);
        }

        return false;
    }
}
