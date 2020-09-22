package metodos;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CentralizarColumnasJTable extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       
       setHorizontalAlignment(SwingConstants.CENTER);
       return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);        

    }   

}
