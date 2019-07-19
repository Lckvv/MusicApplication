package com.music.controllers;

import com.music.TemplateFx.SongListModel;
import com.music.TemplateFx.SongsFx;
import com.music.TemplateFx.SongsModel;
import com.music.database.dao.SongsDao;
import com.music.utils.DialogsUtils;
import com.music.utils.exceptions.ApplicationException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.List;

public class BoyerSearchController {

	private final static int ASIZE = 5000;
	private static int bad_character_shift[] = new int[ASIZE];
	private static int good_suffix_shift[];
	private static int suff[];
	@FXML
	private TextArea searchTextArea;
	@FXML
	private TextFlow searchFlow;
	@FXML
	private Button searchButton;
	private SongsModel songsModel;
	private SongsDao songsDao;
	private SongListModel songListModel;
	private SongsFx songsFx;

	//Boyer-Moore algorithm
	private static void BM_alg(String text, String pattern) {
		int i, j;
		int m = pattern.length();
		int n = text.length();

		pre_bad_character_shift(pattern);
		pre_good_suffix_shift(pattern);

		j = 0;
		while (j <= n - m) {
			for (i = m - 1; i >= 0 && pattern.charAt(i) == text.charAt(i + j); --i) ;
			if (i < 0) {
				System.out.print(j + " ");
				j += good_suffix_shift[0];
			} else
				j += Math.max(good_suffix_shift[i], bad_character_shift[text.charAt(i + j)] - m + 1 + i);
			System.out.println("bad");
		}
	}

	//prepare bad character shift table
	private static void pre_bad_character_shift(String pattern) {
		int m = pattern.length();

		for (int i = 0; i < ASIZE; i++) {
			bad_character_shift[i] = m;
		}

		for (int i = 0; i < m - 1; ++i) {
			bad_character_shift[pattern.charAt(i)] = m - i - 1;
		}
	}

	//prepare good_suffix_shift table
	private static void pre_good_suffix_shift(String pattern) {
		int j = 0;
		int m = pattern.length();
		good_suffix_shift = new int[m];

		pre_suff(pattern);

		for (int i = 0; i < m; i++) {
			good_suffix_shift[i] = m;
		}

		j = 0;
		for (int i = m - 1; i >= 0; --i) {
			if (suff[i] == i + 1) {
				for (; j < m - 1 - i; ++j) {
					good_suffix_shift[j] = m - 1 - i;
				}
			}
		}

		for (int i = 0; i <= m - 2; ++i) {
			good_suffix_shift[m - 1 - suff[i]] = m - 1 - i;
		}
	}

	//prepare suff table
	private static void pre_suff(String pattern) {
		int j;
		int m = pattern.length();
		suff = new int[m];

		suff[m - 1] = m;
		for (int i = m - 2; i >= 0; --i) {
			for (j = 0; j <= i && pattern.charAt(i - j) == pattern.charAt(m - j - 1); j++) ;
			suff[i] = j;
		}

	}

	public void initialize() {
		this.songListModel = new SongListModel();
		try {
			this.songListModel.init();
		} catch (ApplicationException e) {
			DialogsUtils.errorDialog(e.getMessage());
		}
		bindings();

		songListModel.getSongsFxObservableList();
	}

	public void bindings() {
		this.songListModel.getSongsFxObservableList();
	}

	public void searchOnAction(ActionEvent actionEvent) {
		String text;
		text = searchTextArea.getText();
		String[] words = deleteSpecialCharacters(text);
		ObservableList<SongsFx> list = this.songListModel.getSongsFxObservableList();
		List<String> titleSong = new ArrayList<>();
		for (SongsFx aList : list) {
			String textSong[] = deleteSpecialCharacters(aList.getTextt());
			for (int j = 0; j < textSong.length; j++) {
				if (words[0].equalsIgnoreCase(textSong[j]) && textSong.length - words.length >= 0) {
					for (int k = 1; k < words.length; k++) {
						if (words[k].equalsIgnoreCase(textSong[j + k])) {
							if (words.length - k <= 1) {
								titleSong.add(aList.getName());
							}
						}
					}
				}
			}
		}
		print(titleSong);
	}

	private void print(List<String> titleSong) {
		if (titleSong.isEmpty()) {
			System.out.println("Ten tekst nie pasuje do zadnej piosenki!");
		} else {
			System.out.println("Wprowadzony tekst został odnaleziony w piosenkach: ");
			for (String aTitleSong : titleSong) {
				System.out.println(aTitleSong);
			}
		}
	}


	private String[] deleteSpecialCharacters(String text) {
		text = replaceChars(text);
		String delimiter1 = " ";
		String delimiter2 = "\n";
		text = text.replaceAll(delimiter2, delimiter1);
		String[] words = text.split(delimiter1);
		return words;
	}

	private String replaceChars(String text) {
		text = text.replace(".", "");
		text = text.replace(",", "");
		text = text.replace(":", "");
		text = text.replace("(", "");
		text = text.replace(")", "");
		text = text.replace("*", "");
		text = text.replace("!", "");
		text = text.replace("-", "");
		text = text.replace("'", "");
		text = text.replace("?", "");

		return text;
	}
}
