package notatnik.windows;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.rtf.RTFEditorKit;
import javax.swing.undo.UndoManager;

import notatnik.input.Key;
import notatnik.menu.ClassColor;
import notatnik.menu.ClassFile;
import notatnik.menu.ClassImage;
import notatnik.menu.Edit;
import notatnik.menu.Format;
import notatnik.menu.Settings;
import notatnik.popupmenu.ClassPUMenu;
import notatnik.toolbars.ClassColorToolBar;
import notatnik.toolbars.ClassToolBar;
import notatnik.utils.CustomTextPane;

public class Window implements ActionListener {

	public JFrame frame;
	public CustomTextPane textPane;
	JScrollPane scrollPane;
	JMenuBar menuBar;
	public JMenu file, edit, format, color, image, settings, help, 
		  font, fontSize;
	JMenuItem iNew, iOpen, iSave, iSaveAs, iPrint, iExit, 
			  iUndo, iRedo, 
			  iArial, iComicSansMS, iPacifico, iTimesNewRoman, iSize8, iSize10, iSize12, iSize14, iSize16, iSize18, iSize20, iSize22, 
			  iBlack, iBlue, iGreen, iRed, iWhite, iSkyBlue, iGrassGreen, iBrown,
			  iAddImage,
			  iGraphiteLookAndFeel, iLunaLookAndFeel, iNoireLookAndFeel, iTextureLookAndFeel, iNimbus, iMotif,
			  iHelp,
			  pCopy, pPaste, pCut, pSelectAll;
	JToolBar toolBar;
	public JButton bBold, bItalic, bUnderline, bCheckMark, bLeft, bRight, bCenter, bJustify, bFind;
	JTextField txtSearch;
	JPopupMenu popupMenu;
	
	public ClassFile classfile = new ClassFile(this);//wkladamy this bo w zrobinej przez nas klasie file w construktorze bylo Window a my jestesy w klasie window
	Format classFormat = new Format(this);
	ClassColor classColor = new ClassColor(this);
	ClassImage classImage = new ClassImage(this);
	Edit classEdit = new Edit(this);
	Settings classSettings = new Settings(this);
	Key key = new Key(this);
	public UndoManager undoManager = new UndoManager();
	ClassToolBar classToolBar = new ClassToolBar(this);
	ClassColorToolBar classColorToolBar = new ClassColorToolBar(this);
	ClassPUMenu classPUMenu = new ClassPUMenu(this);
		
	public Window() {

		createWindow();
		createTextPane();
		createMenuBar();
		createFile();
		createEdit();
		createFormat();
		createColor();
		createImage();
		createSettings();
		createHelp();
		createPopupMenu();
		createToolBar();
		CustomCursor();
		classColorToolBar.createColorToolBar();
		
		classSettings.chooseLookAndFeel("Texture Look And Feel");//defoltowy look and feel a defoltowa czcionka jest zapisana w Settings w każdym look and feel //i jak tu zmienia na inny look and feel to bede miec inna czcionke
		frame.revalidate();
	}
	
	public void createWindow() {
		frame = new JFrame("Diary");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createTextPane() {
	    textPane = new CustomTextPane();
	    textPane.setEditorKit(new RTFEditorKit());//to dopisuje zebym mogla save text from jtextpane z formatowaniem ktore wybiore a nie tylko jako pusty tekst
	    
    	textPane.addKeyListener(key);

		//dzieki temu mozemy cofac i ponawiac zapisane rzeczy w notatniku to sie robi do undo i redo
		textPane.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				undoManager.addEdit(e.getEdit());
			}
		});
		
		scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//as needed jak bedzie potrzebny to sie wyswietli
		scrollPane.setBorder(BorderFactory.createEmptyBorder());//dzieki temu zniknely granice miedzy scrollpane a polem tekstowym
		frame.add(scrollPane);
	}
	
	public void createMenuBar() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);//menu bar robimy zawsze set a nie add
		
		file = new JMenu("File");
		edit = new JMenu("Edit");
		format = new JMenu("Format");
		color = new JMenu("Color");
		image = new JMenu("Image");
		settings = new JMenu("Settings");
		help = new JMenu("Help");
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(format);
		menuBar.add(color);
		menuBar.add(image);
		menuBar.add(settings);
		menuBar.add(help);
	}
	
	public void createFile() {
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);//implementujemy Action listener do tej klasy(Window) wiec musi byc this
		iNew.setActionCommand("New");//to przesyla nas do ponizszego action performed
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		
		iSaveAs = new JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("Save As");
		
		iPrint = new JMenuItem("Print");
		iPrint.addActionListener(this);
		iPrint.setActionCommand("Print");
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		
		file.add(iNew);
		file.add(iOpen);
		file.add(iSave);
		file.add(iSaveAs);
		file.add(iPrint);
		file.add(iExit);
	}
	
	public void createEdit() {
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		
		edit.add(iUndo);
		edit.add(iRedo);
	}
	
	public void createFormat() {

		font = new JMenu("Font");

		iArial = new JMenuItem("Arial");
		iArial.addActionListener(this);
		iArial.setActionCommand("Arial");
		
		iComicSansMS = new JMenuItem("Comic Sans MS");
		iComicSansMS.addActionListener(this);
		iComicSansMS.setActionCommand("Comic Sans MS");
		
		iPacifico = new JMenuItem("Pacifico");
		iPacifico.addActionListener(this);
		iPacifico.setActionCommand("Pacifico");
		
		iTimesNewRoman = new JMenuItem("Times New Roman");
		iTimesNewRoman.addActionListener(this);
		iTimesNewRoman.setActionCommand("Times New Roman");
		
		font.add(iArial);
		font.add(iComicSansMS);
		font.add(iPacifico);
		font.add(iTimesNewRoman);
		
		fontSize = new JMenu("Font Size");

		iSize8 = new JMenuItem("8");
		iSize8.addActionListener(this);
		iSize8.setActionCommand("8");//to 8 wpisane wykorzystane jest w ponizszym action performed czase 8 mozemy zmienic nazwe np na size 8 ale musi byc i w tej linijce i w caseach ponizej
		
		iSize10 = new JMenuItem("10");
		iSize10.addActionListener(this);
		iSize10.setActionCommand("10");
		
		iSize12 = new JMenuItem("12");
		iSize12.addActionListener(this);
		iSize12.setActionCommand("12");
		
		iSize14 = new JMenuItem("14");
		iSize14.addActionListener(this);
		iSize14.setActionCommand("14");
		
		iSize16 = new JMenuItem("16");
		iSize16.addActionListener(this);
		iSize16.setActionCommand("16");
		
		iSize18 = new JMenuItem("18");
		iSize18.addActionListener(this);
		iSize18.setActionCommand("18");
		
		iSize20 = new JMenuItem("20");
		iSize20.addActionListener(this);
		iSize20.setActionCommand("20");
	
		iSize22 = new JMenuItem("22");
		iSize22.addActionListener(this);
		iSize22.setActionCommand("22");
		
		fontSize.add(iSize8);
		fontSize.add(iSize10);
		fontSize.add(iSize12);
		fontSize.add(iSize14);
		fontSize.add(iSize16);
		fontSize.add(iSize18);
		fontSize.add(iSize20);
		fontSize.add(iSize22);
		
		format.add(font);
		format.add(fontSize);
	}
	
	public void createColor() {
		iBlack = new JMenuItem("Black");
		iBlack.addActionListener(this);
		iBlack.setActionCommand("Black");
		
		iBlue = new JMenuItem("Blue");
		iBlue.addActionListener(this);
		iBlue.setActionCommand("Blue");

		iBrown = new JMenuItem("Brown");
		iBrown.addActionListener(this);
		iBrown.setActionCommand("Brown");

		iGrassGreen = new JMenuItem("Grass Green");
		iGrassGreen.addActionListener(this);
		iGrassGreen.setActionCommand("Grass Green");
		
		iGreen = new JMenuItem("Green");
		iGreen.addActionListener(this);
		iGreen.setActionCommand("Green");
		
		iRed = new JMenuItem("Red");
		iRed.addActionListener(this);
		iRed.setActionCommand("Red");
		
		iSkyBlue = new JMenuItem("Sky Blue");
		iSkyBlue.addActionListener(this);
		iSkyBlue.setActionCommand("Sky Blue");
		
		iWhite = new JMenuItem("White");
		iWhite.addActionListener(this);
		iWhite.setActionCommand("White");
		
		color.add(iBlack);
		color.add(iBlue);
		color.add(iBrown);
		color.add(iGrassGreen);
		color.add(iGreen);
		color.add(iRed);
		color.add(iSkyBlue);
		color.add(iWhite);
	}
	
	public void createImage() {
		iAddImage = new JMenuItem("Add an image");
		iAddImage.addActionListener(this);
		iAddImage.setActionCommand("Add an image");
		
		image.add(iAddImage);
	}
	
	public void createSettings() {
		iTextureLookAndFeel = new JMenuItem("Texture Look And Feel");
		iTextureLookAndFeel.addActionListener(this);
		iTextureLookAndFeel.setActionCommand("Texture Look And Feel");
		
		iNoireLookAndFeel = new JMenuItem("Noire Look And Feel");
		iNoireLookAndFeel.addActionListener(this);
		iNoireLookAndFeel.setActionCommand("Noire Look And Feel");

		iLunaLookAndFeel = new JMenuItem("Luna Look And Feel");
		iLunaLookAndFeel.addActionListener(this);
		iLunaLookAndFeel.setActionCommand("Luna Look And Feel");

		iGraphiteLookAndFeel = new JMenuItem("Graphite Look And Feel");
		iGraphiteLookAndFeel.addActionListener(this);
		iGraphiteLookAndFeel.setActionCommand("Graphite Look And Feel");
		
		iNimbus = new JMenuItem("Nimbus");
		iNimbus.addActionListener(this);
		iNimbus.setActionCommand("Nimbus");
		
		iMotif = new JMenuItem("Motif");
		iMotif.addActionListener(this);
		iMotif.setActionCommand("Motif");
		
		settings.add(iGraphiteLookAndFeel);
		settings.add(iLunaLookAndFeel);
		settings.add(iNoireLookAndFeel);
		settings.add(iTextureLookAndFeel);
		settings.add(iNimbus);
		settings.add(iMotif);
	}
	
	public void createHelp() {
		iHelp = new JMenuItem("Simple Notepad made by Aleksandra Stopka. You can write, format, open, save and print your notes.");
		help.add(iHelp);
	}
	
	public void createPopupMenu() {
		popupMenu = new JPopupMenu();
		textPane.setComponentPopupMenu(popupMenu);//to musi byc od razu set czyli nie dajemy na dole tylko powyzej innych addów

		pCopy = new JMenuItem("Copy");
		pCopy.addActionListener(this);
		pCopy.setActionCommand("Copy");
		
		pPaste = new JMenuItem("Paste");
		pPaste.addActionListener(this);
		pPaste.setActionCommand("Paste");

		pCut = new JMenuItem("Cut");
		pCut.addActionListener(this);
		pCut.setActionCommand("Cut");
		
		pSelectAll = new JMenuItem("Select All");
		pSelectAll.addActionListener(this);
		pSelectAll.setActionCommand("Select All");
		
		popupMenu.add(pCopy);
		popupMenu.add(pPaste);
		popupMenu.add(pCut);
		popupMenu.add(pSelectAll);
	}
	
	public void createToolBar() {
		toolBar = new JToolBar();
		toolBar.setFloatable(false);//dzieki temu ze jest false nie mozemy przesunąć paska narzedzi tylko bedze na stale na gorze bo dalismy north a jesli tego nie ma lub jest true to mozemy go przeciagnąć
		
		bBold = new JButton("B");
		bBold.setFont(new Font("Arial", Font.PLAIN, 20));
		bBold.setPreferredSize(new Dimension(30, 30));
		bBold.addActionListener(this);
		bBold.setActionCommand("B");
		bBold.setFocusable(false);
		
		bItalic = new JButton(" / ");
		bItalic.setFont(new Font("Arial", Font.PLAIN, 20));
		bItalic.setPreferredSize(new Dimension(30, 30));
		bItalic.addActionListener(this);
		bItalic.setActionCommand("/");
		bItalic.setFocusable(false);

		bUnderline = new JButton("U");
		bUnderline.setFont(new Font("Arial", Font.PLAIN, 20));
		bUnderline.setPreferredSize(new Dimension(30, 30));
		bUnderline.addActionListener(this);
		bUnderline.setActionCommand("U");
		bUnderline.setFocusable(false);

		bCheckMark = new JButton(new ImageIcon("res/GoldPen.png"));
		bCheckMark.addActionListener(this);
		bCheckMark.setActionCommand("CM");
		bCheckMark.setFocusable(false);

		bLeft = new JButton(new ImageIcon("res/alignment-left16.png"));
		bLeft.addActionListener(this);
		bLeft.setActionCommand("Left");
		bLeft.setFocusable(false);

		bRight = new JButton(new ImageIcon("res/alignment-right16.2pixels"));	
		bRight.addActionListener(this);
		bRight.setActionCommand("Right");
		bRight.setFocusable(false);

		bCenter = new JButton(new ImageIcon("res/center-alignment.png"));
		bCenter.addActionListener(this);
		bCenter.setActionCommand("Center");
		bCenter.setFocusable(false);

		bJustify = new JButton(new ImageIcon("res/justify-alignment20.png"));
		bJustify.addActionListener(this);
		bJustify.setActionCommand("Justify");
		bJustify.setFocusable(false);

		bFind = new JButton("Find");
		bFind.setFont(new Font("Arial", Font.PLAIN, 16));
		bFind.addActionListener(this);
		bFind.setFocusable(false);
		
		txtSearch = new JTextField("");
		txtSearch.setFont(new Font("Arial", Font.PLAIN, 16));
		
		toolBar.add(bBold);
		toolBar.add(bItalic);
		toolBar.add(bUnderline);
		toolBar.add(bCheckMark);
		toolBar.add(bLeft);
		toolBar.add(bRight);
		toolBar.add(bCenter);
		toolBar.add(bJustify);
		toolBar.add(bFind);
		toolBar.add(txtSearch);
		
		frame.add(toolBar, BorderLayout.NORTH);
	}
	
	public void CustomCursor() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("res/BirdIcon48.png");
		Point point = new Point(0, 20);
		Cursor cursor = toolkit.createCustomCursor(image, point, "Cursor");
		frame.setCursor(cursor);//dodaje nasz kursor do toolbaru i paskamenu czyli do calego frame
		textPane.setCursor(cursor);//dodaje nasz kursor do textpane
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();//command bedzie oznaczalo nacisniecie new i innych buttonow

		switch(command) {
		case "New": classfile.file_New();//if action command = "New"
		break;
		case "Open": classfile.file_Open();
		break;
		case "Save": classfile.file_Save();
		break;
		case "Save As": classfile.file_SaveAs();
		break;
		case "Print": classfile.file_Print();
		break;
		case "Exit": classfile.file_Exit();
		break;
		case "Undo": classEdit.undo();
		break;
		case "Redo": classEdit.redo();
		break;
		case "Add an image": classImage.addImage();
		break;
		case "Graphite Look And Feel": classSettings.chooseLookAndFeel(command);
		break;
		case "Luna Look And Feel": classSettings.chooseLookAndFeel(command);
		break;
		case "Noire Look And Feel": classSettings.chooseLookAndFeel(command);
		break;
		case "Texture Look And Feel": classSettings.chooseLookAndFeel(command);
		break;
		case "Nimbus": classSettings.chooseLookAndFeel(command);
		break;
		case "Motif": classSettings.chooseLookAndFeel(command);
		break;
		}
		
		classFormat.setFont(command);
		classFormat.setSize(command);
		classColor.chooseColor(command);
		classToolBar.chooseStyle(command);
		classToolBar.chooseParagraph(command);
		classPUMenu.puMenu(command);
	
		Object item = e.getSource();

		if(item == bFind) {
			if(txtSearch.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Wyraz nie został wpisany!");
			}
			else {
				String text = textPane.getText();
				String searched = txtSearch.getText();
				int i = 0;
				int index;
				int startIndex = 0;
				while((index = text.indexOf(searched, startIndex)) != -1) {
					startIndex = index + searched.length();
					i++;
				}
				JOptionPane.showMessageDialog(null, searched + " występuje " + i + " razy");
			}
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public JMenu getFile() {
		return file;
	}

	public JMenu getEdit() {
		return edit;
	}

	public JMenu getFormat() {
		return format;
	}

	public JMenu getColor() {
		return color;
	}

	public JMenu getImage() {
		return image;
	}

	public JMenu getSettings() {
		return settings;
	}

	public JMenu getHelp() {
		return help;
	}

	public JMenu getFont() {
		return font;
	}

	public JMenu getFontSize() {
		return fontSize;
	}

	public JMenuItem getiNew() {
		return iNew;
	}

	public JMenuItem getiOpen() {
		return iOpen;
	}

	public JMenuItem getiSave() {
		return iSave;
	}

	public JMenuItem getiSaveAs() {
		return iSaveAs;
	}

	public JMenuItem getiPrint() {
		return iPrint;
	}

	public JMenuItem getiExit() {
		return iExit;
	}

	public JMenuItem getiUndo() {
		return iUndo;
	}

	public JMenuItem getiRedo() {
		return iRedo;
	}

	public JMenuItem getiArial() {
		return iArial;
	}

	public JMenuItem getiComicSansMS() {
		return iComicSansMS;
	}

	public JMenuItem getiPacifico() {
		return iPacifico;
	}

	public JMenuItem getiTimesNewRoman() {
		return iTimesNewRoman;
	}

	public JMenuItem getiSize8() {
		return iSize8;
	}

	public JMenuItem getiSize10() {
		return iSize10;
	}

	public JMenuItem getiSize12() {
		return iSize12;
	}

	public JMenuItem getiSize14() {
		return iSize14;
	}

	public JMenuItem getiSize16() {
		return iSize16;
	}

	public JMenuItem getiSize18() {
		return iSize18;
	}

	public JMenuItem getiSize20() {
		return iSize20;
	}

	public JMenuItem getiSize22() {
		return iSize22;
	}

	public JMenuItem getiBlack() {
		return iBlack;
	}

	public JMenuItem getiBlue() {
		return iBlue;
	}

	public JMenuItem getiGreen() {
		return iGreen;
	}

	public JMenuItem getiRed() {
		return iRed;
	}

	public JMenuItem getiWhite() {
		return iWhite;
	}

	public JMenuItem getiSkyBlue() {
		return iSkyBlue;
	}

	public JMenuItem getiGrassGreen() {
		return iGrassGreen;
	}

	public JMenuItem getiBrown() {
		return iBrown;
	}

	public JMenuItem getiAddImage() {
		return iAddImage;
	}

	public JMenuItem getiGraphiteLookAndFeel() {
		return iGraphiteLookAndFeel;
	}

	public JMenuItem getiLunaLookAndFeel() {
		return iLunaLookAndFeel;
	}

	public JMenuItem getiNoireLookAndFeel() {
		return iNoireLookAndFeel;
	}

	public JMenuItem getiTextureLookAndFeel() {
		return iTextureLookAndFeel;
	}

	public JMenuItem getiNimbus() {
		return iNimbus;
	}

	public JMenuItem getiMotif() {
		return iMotif;
	}

	public JMenuItem getiHelp() {
		return iHelp;
	}

	public JMenuItem getpCopy() {
		return pCopy;
	}

	public JMenuItem getpPaste() {
		return pPaste;
	}

	public JMenuItem getpCut() {
		return pCut;
	}

	public JMenuItem getpSelectAll() {
		return pSelectAll;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}

	public JButton getbBold() {
		return bBold;
	}

	public JButton getbItalic() {
		return bItalic;
	}

	public JButton getbUnderline() {
		return bUnderline;
	}

	public JButton getbCheckMark() {
		return bCheckMark;
	}

	public JButton getbLeft() {
		return bLeft;
	}

	public JButton getbRight() {
		return bRight;
	}

	public JButton getbCenter() {
		return bCenter;
	}

	public JButton getbJustify() {
		return bJustify;
	}

	public JButton getbFind() {
		return bFind;
	}

	public JTextField getTxtSearch() {
		return txtSearch;
	}

	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}

	public ClassFile getClassfile() {
		return classfile;
	}

	public Format getClassFormat() {
		return classFormat;
	}

	public ClassColor getClassColor() {
		return classColor;
	}

	public ClassImage getClassImage() {
		return classImage;
	}

	public Edit getClassEdit() {
		return classEdit;
	}

	public Settings getClassSettings() {
		return classSettings;
	}

	public Key getKey() {
		return key;
	}

	public ClassToolBar getClassToolBar() {
		return classToolBar;
	}

	public ClassColorToolBar getClassColorToolBar() {
		return classColorToolBar;
	}

	public ClassPUMenu getClassPUMenu() {
		return classPUMenu;
	}
}
