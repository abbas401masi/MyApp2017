package com.myapp.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;

public class TilesDefinitionsConfig implements DefinitionsFactory {

	private static final Map<String, Definition> tilesDefinitions = new HashMap<String, Definition>();
	private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/admin/defaultLayout.jsp");

	@Override
	public Definition getDefinition(String name, Request tilesContext) {
		return tilesDefinitions.get(name);
	}

	/**
	 * @param name
	 *            <code>Name of the view</code>
	 * @param title
	 *            <code>Page title</code>
	 * @param body
	 *            <code>Body JSP file path</code>
	 *
	 *            <code>Adds default layout definitions</code>
	 */

	private static void addDefaultLayoutDef(String name, String title, String body) {
		Map<String, Attribute> attributes = new HashMap<String, Attribute>();
		attributes.put("title", new Attribute(title));
		attributes.put("header", new Attribute("/WEB-INF/admin/controls/header.jsp"));
		attributes.put("menu", new Attribute("/WEB-INF/admin/controls/menu.jsp"));
		attributes.put("body", new Attribute(body));
		attributes.put("footer", new Attribute("/WEB-INF/admin/controls/footer.jsp"));
		tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
	}

	public static void addDefinitions() {
		addDefaultLayoutDef("welcome", "Welcome", "/WEB-INF/admin/home.jsp");
	}
}
