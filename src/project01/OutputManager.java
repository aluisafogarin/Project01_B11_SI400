package project01;

import java.io. *;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

public class OutputManager {

    private void orderMap() {
        
    }

    private void recordOutputFile( String pathString_CSV, String Name_file_CSV) {
        try {
			PrintWriter pWriter = new PrintWriter(
					new File(pathString_CSV)+"\\"+Name_file_CSV+".csv");
			proper_word_outputs();// Output
			pWriter.write(getbuilder_string().toString());
			pWriter.close();
            JOptionPane.showMessageDialog(null, "Finished writing the file: "+Name_file_CSV+" in the path "+pathString_CSV+"\\"+Name_file_CSV+".csv");
            // Generated .csv file
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error:" + e); //Error message
		}
	}
}
        /*
        BufferedReader in = new BufferedReader (new FileReader ( " arquivo.txt "));
        //cria um objeto virtual para a leitura de um arquivo de texto existente
        conteúdo string;
        while (( content = in.readLine ()) ! = null) { System.out.println
            (conteúdo) ;
        }
        in.close ();
    }
}*/