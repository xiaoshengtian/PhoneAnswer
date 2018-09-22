package com.zcj.blg.phoneanswer.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zcj.blg.phoneanswer.R;
import com.zcj.blg.phoneanswer.bean.User;
import com.zcj.blg.phoneanswer.util.UIUtils;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by zcj on 2018/9/17.
 */

public class PersonalInfoActivity extends Activity {
    private ImageView personinfo_avatar;
    private TextView personinfo_id;
    private TextView personinfo_nickname;
    private String nick;
    private String path;
    private TextView personinfo_save;
    private Context context;
    private TextView title;
    private ImageView left;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        context = PersonalInfoActivity.this;
        personinfo_avatar = (ImageView) findViewById(R.id.personinfo_avatar);
        personinfo_id = (TextView) findViewById(R.id.personinfo_id);
        personinfo_nickname = (TextView) findViewById(R.id.personinfo_nickname);
        personinfo_save = (TextView) findViewById(R.id.personinfo_save);

        title = (TextView) findViewById(R.id.title);
        left = (ImageView) findViewById(R.id.left);

        title.setText("个人信息");

        final User user = BmobUser.getCurrentUser(User.class);
        nick = user.getUserNick();
        personinfo_nickname.setText(nick);
        personinfo_id.setText(user.getObjectId());
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        personinfo_avatar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                /* 开启Pictures画面Type设定为image */
//                intent.setType("image/*");
//                /* 使用Intent.ACTION_GET_CONTENT这个Action */
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                /* 取得相片后返回本画面 */
//                startActivityForResult(intent, 1);
//            }
//        });
        personinfo_nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context, R.style.dialog);
                View view = LayoutInflater.from(context).inflate(R.layout.dialog_nick, null);
                final EditText editText = (EditText) view.findViewById(R.id.nick);
                TextView confirm = (TextView) view.findViewById(R.id.confirm);
                editText.setHint(nick);
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        personinfo_nickname.setText(editText.getText().toString());
                        dialog.dismiss();
                    }
                });
                dialog.setContentView(view);
                dialog.show();
                WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
                lp.width = (int) (UIUtils.getScreenWidth(context) * 0.6);
                lp.height = (int) (UIUtils.getScreenWidth(context) * 0.4);
                dialog.getWindow().setAttributes(lp);
            }
        });

        personinfo_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updata();
            }
        });
    }

    private void updata() {
        User newUser = new User();
        newUser.setUserNick(personinfo_nickname.getText().toString());
        BmobUser bmobUser = BmobUser.getCurrentUser(User.class);
        newUser.update(bmobUser.getObjectId(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Toast.makeText(context, "更新用户信息成功", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(context, "修改失败", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode == RESULT_OK) {
//            Uri uri = data.getData();
//            path = getImagePath(uri, null);
//            ContentResolver cr = this.getContentResolver();
//            try {
//                Log.e("qwe", path.toString());
//                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
//                /* 将Bitmap设定到ImageView */
//                personinfo_avatar.setImageBitmap(bitmap);
//            } catch (FileNotFoundException e) {
//                Log.e("qwe", e.getMessage(), e);
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//    private String getImagePath(Uri uri, String seletion) {
//        String path = null;
//        Cursor cursor = getContentResolver().query(uri, null, seletion, null, null);
//        if (cursor != null) {
//            if (cursor.moveToFirst()) {
//                path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
//            }
//            cursor.close();
//
//        }
//        return path;
//
//    }


}
