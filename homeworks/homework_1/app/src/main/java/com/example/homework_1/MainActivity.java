package com.example.homework_1;

import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = (Button) gridLayout.getChildAt(i * 3 + j);
            }
        }
    }

    public void onCellClicked(View view) {
        if (!((Button) view).getText().toString().isEmpty()) {
            return; // ячейка уже занята
        }

        if (player1Turn) {
            ((Button) view).setText("X");
        } else {
            ((Button) view).setText("O");
        }

        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                showToast("Player 1 wins!");
            } else {
                showToast("Player 2 wins!");
            }
            disableAllButtons();
        } else if (roundCount == 9) {
            showToast("Draw!");
        } else {
            player1Turn = !player1Turn;
        }
    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];

        // Заполнение массива field из значений кнопок
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        // Проверка строк
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1]) &&
                    field[i][0].equals(field[i][2]) &&
                    !field[i][0].isEmpty()) {
                return true;
            }
        }

        // Проверка столбцов
        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i]) &&
                    field[0][i].equals(field[2][i]) &&
                    !field[0][i].isEmpty()) {
                return true;
            }
        }

        // Проверка диагоналей
        if (field[0][0].equals(field[1][1]) &&
                field[0][0].equals(field[2][2]) &&
                !field[0][0].isEmpty()) {
            return true;
        }
        if (field[0][2].equals(field[1][1]) &&
                field[0][2].equals(field[2][0]) &&
                !field[0][2].isEmpty()) {
            return true;
        }

        return false;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
}