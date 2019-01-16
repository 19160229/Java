package ui;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Sta_Audit_TableModel extends AbstractTableModel{
	// �����ͷ����
		String[] head = { "ѡ��","��ٵ���", "�����", "������", "��ʼ����","��������", "����", "����" };
		// ������������
		// Class[]
		// typeArray={Object.class,Object.class,Boolean.class,int.class,Object.class,Object.class};
	 
		
		
		// ������ÿһ�е���������
		@SuppressWarnings("rawtypes")
		Class[] typeArray = { Boolean.class,Object.class, Object.class, 
				/*JComboBox.class*/Object.class,/*Integer.class*/Object.class, Object.class,Object.class,  Object.class };
	 
		Object[][] data ;
	 
		public Sta_Audit_TableModel(Object[][] data) {
			this.data=data;
		}
		
		// ��ñ�������
		public int getColumnCount() {
			return head.length;
		}
	 
		// ��ñ�������
		public int getRowCount() {
			return data.length;
		}
	 
		// ��ñ���������
		@Override
		public String getColumnName(int column) {
			return head[column];
		}
	 
		// ��ñ��ĵ�Ԫ�������
		public Object getValueAt(int rowIndex, int columnIndex) {
			return data[rowIndex][columnIndex];
		}
	 
		// ʹ�����пɱ༭��
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}
	 
		// �滻��Ԫ���ֵ
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			data[rowIndex][columnIndex] = aValue;
			fireTableCellUpdated(rowIndex, columnIndex);
		}
	 
		// ʵ���������boolean�Զ�ת��JCheckbox
		/*
		 * ��Ҫ�Լ���celleditor��ô�鷳�ɡ�jtable�Զ�֧��Jcheckbox��
		 * ֻҪ����tablemodel��getColumnClass����һ��boolean��class�� jtable���Զ���һ��Jcheckbox���㣬
		 * ���value��true����falseֱ�Ӷ�table���Ǹ�cell��ֵ�Ϳ���
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int columnIndex) {
			return typeArray[columnIndex];// ����ÿһ�е���������
		}
}
