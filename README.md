#Length converter
by Wisa Powthongchin


This repository is a project for practice using JavaFX by writing Length unit converter GUI application


Did not use static .load() method of FXMLLoader class because I encounter some error while specifying Controller so I need to manually specify controller by creating loader instead of using the static .load() method

		FXMLLoader loader = new FXMLLoader(getClass().getResource("ConverterUI.fxml"));
		loader.setController(new ConverterController());
