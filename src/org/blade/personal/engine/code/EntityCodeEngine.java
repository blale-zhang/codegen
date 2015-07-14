package org.blade.personal.engine.code;

import java.io.StringWriter;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.blade.personal.engine.CodeEngine;
import org.blade.personal.mode.ModelDefined;
import org.blade.personal.mode.ModelPropertyDefined;

public class EntityCodeEngine implements CodeEngine {

	@Override
	public String generate(ModelDefined modeDefined) {

		try {

			// 初始化参数
			Properties properties = new Properties();
			
			VelocityEngine velocityEngine = new VelocityEngine();
			 
			properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, "E:\\git\\codeGen\\src\\org\\blade\\personal\\engine\\code\\");
			 
			velocityEngine.init(properties);

			VelocityContext context = new VelocityContext();

			List<ModelPropertyDefined> list = modeDefined.getPropreties();

			context.put("entity", modeDefined.getName());
			context.put("tableName", "person");

			context.put("dao_delete", "daoDelete.vm");
			context.put("properties", list);
			/* lets render a template */

			StringWriter w = new StringWriter();

			Template template = velocityEngine.getTemplate("entityTemplate.vm");
			template.merge(context, w);
			/*velocityEngine.mergeTemplate(
							"entityTemplate.vm",
							"ISO-8859-1", context, w);*/

			System.out.println(" template : " + w);
		} catch (Exception e) {
			System.out.println("Problem merging template : " + e);
		}

		return null;
	}

}
