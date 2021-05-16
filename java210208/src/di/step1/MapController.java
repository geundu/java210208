package di.step1;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MapController extends AbstractController {

	private Map<String, String> mapBean = null;

	public void setMapBean(Map<String, String> mapBean) {
		this.mapBean = mapBean;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println(mapBean.get("prop1"));
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
