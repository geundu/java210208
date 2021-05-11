package di.step1;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MapController extends AbstractController {

	private Map<String, String> mapBean = null;

	public void setMapBean(Map<String, String> mapBean) {
		this.mapBean = mapBean;
	}

	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletRequest res) {
		System.out.println(mapBean.get("prop1"));
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
