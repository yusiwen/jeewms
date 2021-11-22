package test;

import com.sap.conn.jco.JCoTable;
import com.zzjee.sap.SapRFC;
import org.jeecgframework.codegenerate.window.CodeWindow;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;


/**
 * 【单表模型】代码生成器入口
 * @author admin
 * @site www.jeecg.org
 *
 */
public class JeecgOneGUI {

	public static void main(String[] args) {
//		CodeWindow  codeWindow = new CodeWindow();
//		codeWindow.pack();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			SapRFC saprfc = SapRFC.getInstance();
			saprfc.prepare("ZZKMES_FM_PP112");
			saprfc.execCall();
//            saprfc.getParamTableList()
			JCoTable tab = saprfc.getParamTableList("IT_OUT");
			System.out.print("rows:" + tab.getNumRows());
			result.put("IT_OUT", tab);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}
}
