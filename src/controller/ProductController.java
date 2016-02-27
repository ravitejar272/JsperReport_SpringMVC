package controller;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import report.ProductReport;

@Controller
@RequestMapping(value = "product")
public class ProductController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void index(HttpServletRequest request, HttpServletResponse response) {

		try {
			ProductReport pr = new ProductReport();
			pr.findAll();
			JRDataSource jrDataSource = new JRBeanCollectionDataSource(pr.findAll());
			
			
//			String jrxmlFile = "./report/ProductReport.jrxmb";
//			InputStream input = new FileInputStream(new File(jrxmlFile));
			
			InputStream input = Thread.currentThread().getContextClassLoader().
					getResourceAsStream("report/productreport.jrxml");
			
			JasperReport jasperReport = JasperCompileManager.compileReport(input);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);
			JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
