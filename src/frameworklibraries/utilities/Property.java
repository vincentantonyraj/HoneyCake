package frameworklibraries.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Property {

	private HashMap<String, String> list;
	private String filename;
	private static Property _property;
	private static Object _syncObj = new Object();

	public Property() {
		try {
			String filename = System.getProperty("user.dir")
					+ "\\src\\Automation.properties";
			reload(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reload() throws Exception {
		reload(this.filename);
	}

	public void reload(String filename) throws Exception {
		this.filename = filename;
		list = new HashMap<String, String>();

		if (new File(filename).exists()) {
			loadFromFile(filename);
		} else {
			new File(filename).createNewFile();
		}
	}

	public Property GetPropertyInstance() {
		if (_property == null) {
			synchronized (_syncObj) {
				if (_property == null) {
					_property = new Property();
				}
			}

		}
		return _property;
	}

	public void Save(String filename) throws Exception {
		this.filename = filename;
		File file = new File(filename);

		BufferedWriter writer = null;

		if (!file.exists())
			file.createNewFile();

		writer = new BufferedWriter(new FileWriter(file));

		for (Map.Entry<String, String> entry : list.entrySet())
			if (entry.getKey() != null || entry.getKey().trim() != null) {
				writer.write(entry.getKey() + "=" + entry.getValue());
				writer.newLine();
			}

		writer.close();
	}

	public void Save() throws Exception {
		Save(this.filename);
	}

	public String get(String fieldName) {
		return list.containsKey(fieldName) ? list.get(fieldName).toString()
				: null;
	}

	public void set(String fieldName, String value) throws Exception {
		if (list.containsKey(fieldName)) {
			list.remove(fieldName);
			list.put(fieldName, value);
		} else
			list.put(fieldName, value);
		Save();
	}

	private void loadFromFile(String file) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = br.readLine()) != null) {
			if ((!line.isEmpty() || line.trim() != "")
					&& (!line.startsWith(";")) && (!line.startsWith("#"))
					&& (!line.startsWith("'")) && (line.contains("="))) {
				int index = line.indexOf('=');
				String key = line.substring(0, index).trim();
				String value = line.substring(index + 1).trim();

				if ((value.startsWith("\"") && value.endsWith("\""))
						|| (value.startsWith("'") && value.endsWith("'"))) {
					value = value.substring(1, value.length() - 2);
				}

				list.put(key, value);
			}
		}
		br.close();
	}

}
