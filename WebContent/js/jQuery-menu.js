
(function($){
	
	
	$.fn.menu = function(){
		return this;
	}
	
	var options = {
			
			url:"",
			param:{},
			container:'',
			selected:[1]
				
	};
	
	var loacalThis;
	$.fn.menu = function(opt){
		
		opt = $.extend( options , opt);
		$.fn.menu.loadData(opt);
		loacalThis = this;
		return this;
	}
	
	$.fn.menu.prototype = function(){
		
	}
	
	$.fn.menu.loadData = function(opt){

		$.ajax({
		url:opt.url,
		data: opt.param,
		type:'POST',
		dataType:'json',
		success:function(backData){
			
			var html = [];
			if(backData && backData.length) {
				// TODO
				html.push('<ul class="page-sidebar-menu" data-auto-scroll="true" data-slide-speed="200">');
				//缩小版图标
				html.push('<li class="sidebar-toggler-wrapper">');
				html.push('<div class="sidebar-toggler hidden-phone">');
				html.push('</div>');
				html.push('</li>');
				for(var i = 0 ; i < backData.length; i++){
//					html.push('::before');
					if(i == opt.selected[0]){
						html.push('<li class="start active " dataId="'+backData[i].id + '" >');// 是否默认选中第一个
					}else if(i == backData.length){
						html.push('<li  dataId="'+backData[i].id + '"  >');// 是否默认选中第一个
					}else{
						html.push('<li class="last" dataId="'+backData[i].id + '"  >');// 是否默认选中第一个
					}
					
					html.push('<a href="'+ opt.ctx +  backData[i].url +'" tppabs="http://www.keenthemes.com/preview/metronic_admin/index.html">');
					if(backData[i].icon){//第一层节点图标，如果没配置将使用默认图标
						html.push('<i class=" fa ' + backData[i].icon + '"></i>');
					}else{
						html.push('<i class=" fa fa-default"></i>');
					}
					html.push('<span class="title">');
					html.push(backData[i].name);
					html.push('</span>');
					html.push('<span class="selected">');
					html.push('</span>');
					if(backData[i].sonNodeNum){//如果有子节点的话，TODO 加载子节点
						html.push('<span class="arrow">');
						html.push('</span>');
					}
					html.push('</a>');
					html.push('</li>');
				}
			}
			html.push('</ul>');
//			html.push('::after');
			loacalThis.append(html.join('')); 
			
			$("." + opt.menuClass).find('span.selected').click(function(){
				
				alert("加载子节点");
//				$.fn.menu.loadSubData();
			})
		}
	});

	}
	
	$.fn.menu.loadSubData = function(opt){


		$.ajax({
		url:opt.url,
		data: opt.param,
		type:'POST',
		dataType:'json',
		success:function(backData){
			
			var html = [];
			if(backData && backData.length) {
				// TODO
				html.push('<ul class="sub-menu" >');
				for(var i = 0 ; i < backData.length; i++){
					
					html.push('<li  dataId="'+backData[i].id + '"  >');// 是否默认选中第一个
					
					html.push('<a href="'+ backData[i].url +'" tppabs="http://www.keenthemes.com/preview/metronic_admin/index.html">');
					if(backData[i].icon){
						html.push('<i class="' + backData[i].icon + '"></i>');
					}
					html.push('<span class="title">');
					html.push(backData[i].name);
					html.push('</span>');
					html.push('<span class="selected">');
					html.push('</span>');
					if(backData[i].sonNodeNum){//如果有子节点的话，TODO 加载子节点
						html.push('<span class="arrow">');
						html.push('</span>');
					}
					html.push('</a>');
					html.push('</li>');
				}
			}
			html.push('</ul>');
			loacalThis.append(html.join('')); 
			
			$("." + opt.menuClass).find('span.selected').click(function(){
				
				alert('dddd');
			})
		}
	});

	
	}
	
})(jQuery);


/*
 * <div class="page-sidebar navbar-collapse collapse"> <!-- add
 * "navbar-no-scroll" class to disable the scrolling of the sidebar menu -->
 * <!-- BEGIN SIDEBAR MENU -->
 * <ul class="page-sidebar-menu" data-auto-scroll="true" data-slide-speed="200">
 * <li class="sidebar-toggler-wrapper"> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
 * <div class="sidebar-toggler hidden-phone"> </div> <!-- BEGIN SIDEBAR TOGGLER
 * BUTTON --> </li> <li class="sidebar-search-wrapper"> <!-- BEGIN RESPONSIVE
 * QUICK SEARCH FORM --> <form class="sidebar-search"
 * action="http://www.keenthemes.com/preview/metronic_admin/extra_search.html"
 * method="POST"> <div class="form-container"> <div class="input-box"> <a
 * href="javascript:;" class="remove"> </a> <input type="text"
 * placeholder="Search..."> <input type="button" class="submit" value=" ">
 * </div> </div> </form> <!-- END RESPONSIVE QUICK SEARCH FORM --> </li>
 * <li class="start active "> <a href="index.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/index.html"> <i
 * class="fa fa-home"></i> <span class="title"> Dashboard </span> <span
 * class="selected"> </span> </a> </li> <li class=""> <a href="javascript:;"> <i
 * class="fa fa-shopping-cart"></i> <span class="title"> E-Commerce </span>
 * <span class="arrow"> </span> </a>
 * <ul class="sub-menu" style="display: none;"> <li> <a
 * href="ecommerce_index.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ecommerce_index.html">
 * <i class="fa fa-bullhorn"></i> Dashboard </a> </li> <li> <a
 * href="ecommerce_orders.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ecommerce_orders.html">
 * <i class="fa fa-shopping-cart"></i> Orders </a> </li> <li> <a
 * href="ecommerce_orders_view.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ecommerce_orders_view.html">
 * <i class="fa fa-tags"></i> Order View </a> </li> <li> <a
 * href="ecommerce_products.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ecommerce_products.html">
 * <i class="fa fa-sitemap"></i> Products </a> </li> <li> <a
 * href="ecommerce_products_edit.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ecommerce_products_edit.html">
 * <i class="fa fa-file-o"></i> Product Edit </a> </li> </ul> </li>
 * <li class=""> <a href="javascript:;"> <i class="fa fa-gift"></i> <span
 * class="title"> Frontend Themes </span> <span class="arrow"> </span> </a>
 * <ul class="sub-menu" style="display: none;">
 * <li class="tooltips" data-container="body" data-placement="right" data-html="true" data-original-title="Complete E-Commerce Frontend Theme For Metronic Admin">
 * <a
 * href="javascript:if(confirm('http://keenthemes.com/preview/index.php?theme=metronic_ecommerce
 * \n\n�ļ���δ�� Teleport Pro ȡ�أ���Ϊ ��������·��������ʼ��ַ�����õķ�Χ��
 * \n\n��Ҫ�ӷ������ϴ���������'))window.location='http://keenthemes.com/preview/index.php?theme=metronic_ecommerce'"
 * tppabs="http://keenthemes.com/preview/index.php?theme=metronic_ecommerce"
 * target="_blank"> <span class="title"> E-Commerce Frontend </span> </a> </li>
 * <li class="tooltips" data-container="body" data-placement="right" data-html="true" data-original-title="Complete Multipurpose Corporate Frontend Theme For Metronic Admin">
 * <a
 * href="javascript:if(confirm('http://keenthemes.com/preview/index.php?theme=metronic_frontend
 * \n\n�ļ���δ�� Teleport Pro ȡ�أ���Ϊ ��������·��������ʼ��ַ�����õķ�Χ��
 * \n\n��Ҫ�ӷ������ϴ���������'))window.location='http://keenthemes.com/preview/index.php?theme=metronic_frontend'"
 * tppabs="http://keenthemes.com/preview/index.php?theme=metronic_frontend"
 * target="_blank"> <span class="title"> Corporate Frontend </span> </a> </li>
 * </ul> </li> <li> <a href="javascript:;"> <i class="fa fa-cogs"></i> <span
 * class="title"> Page Layouts </span> <span class="arrow "> </span> </a>
 * <ul class="sub-menu"> <li> <a href="index_horizontal_menu.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/index_horizontal_menu.html">
 * Dashboard &amp; Mega Menu </a> </li> <li> <a
 * href="layout_horizontal_sidebar_menu.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_horizontal_sidebar_menu.html">
 * Horizontal &amp; Sidebar Menu </a> </li> <li> <a
 * href="layout_horizontal_menu1.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_horizontal_menu1.html">
 * Horizontal Mega Menu 1 </a> </li> <li> <a href="layout_horizontal_menu2.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_horizontal_menu2.html">
 * Horizontal Mega Menu 2 </a> </li> <li> <a href="layout_search_on_header.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_search_on_header.html">
 * Searchbar On Header </a> </li> <li> <a
 * href="layout_sidebar_toggler_on_header.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_sidebar_toggler_on_header.html">
 * Sidebar Toggler On Header </a> </li> <li> <a
 * href="layout_sidebar_reversed.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_sidebar_reversed.html">
 * <span class="badge badge-roundless badge-success"> new </span> Right Sidebar
 * Page </a> </li> <li> <a href="layout_sidebar_fixed.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_sidebar_fixed.html">
 * Sidebar Fixed Page </a> </li> <li> <a href="layout_sidebar_closed.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_sidebar_closed.html">
 * Sidebar Closed Page </a> </li> <li> <a href="layout_ajax.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_ajax.html">
 * Content Loading via Ajax </a> </li> <li> <a href="layout_disabled_menu.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_disabled_menu.html">
 * Disabled Menu Links </a> </li> <li> <a href="layout_blank_page.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_blank_page.html">
 * Blank Page </a> </li> <li> <a href="layout_boxed_page.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_boxed_page.html">
 * Boxed Page </a> </li> <li> <a href="layout_language_bar.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_language_bar.html">
 * Language Switch Bar </a> </li> <li> <a href="layout_promo.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/layout_promo.html">
 * Promo Page </a> </li> </ul> </li> <li> <a href="javascript:;"> <i class="fa
 * fa-bookmark-o"></i> <span class="title"> UI Features </span> <span
 * class="arrow "> </span> </a> <ul class="sub-menu"> <li> <a
 * href="ui_general.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_general.html">
 * General </a> </li> <li> <a href="ui_buttons.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_buttons.html">
 * Buttons &amp; Icons </a> </li> <li> <a href="ui_typography.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_typography.html">
 * Typography </a> </li> <li> <a href="ui_tabs_accordions_navs.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_tabs_accordions_navs.html">
 * Tabs, Accordions &amp; Navs </a> </li> <li> <a href="ui_tree.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_tree.html"> <span
 * class="badge badge-roundless badge-important"> new </span> Tree View </a>
 * </li> <li> <a href="ui_page_progress_style_1.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_page_progress_style_1.html">
 * <span class="badge badge-roundless badge-warning"> new </span> Page Progress
 * Bar </a> </li> <li> <a href="ui_blockui.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_blockui.html">
 * Block UI </a> </li> <li> <a href="ui_notific8.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_notific8.html">
 * Notific8 Notifications </a> </li> <li> <a href="ui_toastr.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_toastr.html">
 * Toastr Notifications </a> </li> <li> <a href="ui_alert_dialog_api.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_alert_dialog_api.html">
 * <span class="badge badge-roundless badge-important"> new </span> Alerts &amp;
 * Dialogs API </a> </li> <li> <a href="ui_session_timeout.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_session_timeout.html">
 * Session Timeout </a> </li> <li> <a href="ui_idle_timeout.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_idle_timeout.html">
 * User Idle Timeout </a> </li> <li> <a href="ui_modals.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_modals.html">
 * Modals </a> </li> <li> <a href="ui_extended_modals.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_extended_modals.html">
 * Extended Modals </a> </li> <li> <a href="ui_tiles.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_tiles.html">
 * Tiles </a> </li> <li> <a href="ui_datepaginator.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_datepaginator.html">
 * <span class="badge badge-roundless badge-success"> new </span> Date Paginator
 * </a> </li> <li> <a href="ui_nestable.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/ui_nestable.html">
 * Nestable List </a> </li> </ul> </li> <li> <a href="javascript:;"> <i
 * class="fa fa-puzzle-piece"></i> <span class="title"> UI Components </span>
 * <span class="arrow "> </span> </a> <ul class="sub-menu"> <li> <a
 * href="components_pickers.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/components_pickers.html">
 * Pickers </a> </li> <li> <a href="components_dropdowns.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/components_dropdowns.html">
 * Custom Dropdowns </a> </li> <li> <a href="components_form_tools.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/components_form_tools.html">
 * Form Tools </a> </li> <li> <a href="components_editors.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/components_editors.html">
 * Markdown &amp; WYSIWYG Editors </a> </li> <li> <a
 * href="components_ion_sliders.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/components_ion_sliders.html">
 * Ion Range Sliders </a> </li> <li> <a href="components_noui_sliders.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/components_noui_sliders.html">
 * NoUI Range Sliders </a> </li> <li> <a href="components_jqueryui_sliders.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/components_jqueryui_sliders.html">
 * jQuery UI Sliders </a> </li> <li> <a href="components_knob_dials.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/components_knob_dials.html">
 * Knob Circle Dials </a> </li> </ul> </li> <li> <a href="javascript:;"> <i
 * class="fa fa-table"></i> <span class="title"> Form Stuff </span> <span
 * class="arrow "> </span> </a> <ul class="sub-menu"> <li> <a
 * href="form_controls.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/form_controls.html">
 * Form Controls </a> </li> <li> <a href="form_layouts.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/form_layouts.html">
 * Form Layouts </a> </li> <li> <a href="form_editable.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/form_editable.html">
 * <span class="badge badge-roundless badge-warning"> new </span> Form
 * X-editable </a> </li> <li> <a href="form_wizard.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/form_wizard.html">
 * Form Wizard </a> </li> <li> <a href="form_validation.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/form_validation.html">
 * Form Validation </a> </li> <li> <a href="form_image_crop.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/form_image_crop.html">
 * <span class="badge badge-roundless badge-important"> new </span> Image
 * Cropping </a> </li> <li> <a href="form_fileupload.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/form_fileupload.html">
 * Multiple File Upload </a> </li> <li> <a href="form_dropzone.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/form_dropzone.html">
 * Dropzone File Upload </a> </li> </ul> </li> <li> <a href="javascript:;"> <i
 * class="fa fa-envelope-o"></i> <span class="title"> Email Templates </span>
 * <span class="arrow "> </span> </a> <ul class="sub-menu"> <li> <a
 * href="email_newsletter.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/email_newsletter.html">
 * Responsive Newsletter<br> Email Template </a> </li> <li> <a
 * href="email_system.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/email_system.html">
 * Responsive System<br> Email Template </a> </li> </ul> </li> <li class=""> <a
 * href="javascript:;"> <i class="fa fa-sitemap"></i> <span class="title">
 * Pages </span> <span class="arrow"> </span> </a>
 * <ul class="sub-menu" style="display: none;"> <li> <a
 * href="page_portfolio.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/page_portfolio.html">
 * <i class="fa fa-briefcase"></i> <span class="badge badge-warning
 * badge-roundless"> new </span> Portfolio </a> </li> <li> <a
 * href="page_timeline.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/page_timeline.html">
 * <i class="fa fa-clock-o"></i> <span class="badge badge-info"> 4 </span>
 * Timeline </a> </li> <li> <a href="page_coming_soon.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/page_coming_soon.html">
 * <i class="fa fa-cogs"></i> Coming Soon </a> </li> <li> <a
 * href="page_blog.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/page_blog.html"> <i
 * class="fa fa-comments"></i> Blog </a> </li> <li> <a
 * href="page_blog_item.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/page_blog_item.html">
 * <i class="fa fa-font"></i> Blog Post </a> </li> <li> <a
 * href="page_news.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/page_news.html"> <i
 * class="fa fa-coffee"></i> <span class="badge badge-success"> 9 </span> News
 * </a> </li> <li> <a href="page_news_item.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/page_news_item.html">
 * <i class="fa fa-bell"></i> News View </a> </li> <li> <a
 * href="page_about.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/page_about.html"> <i
 * class="fa fa-group"></i> About Us </a> </li> <li> <a
 * href="page_contact.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/page_contact.html">
 * <i class="fa fa-envelope-o"></i> Contact Us </a> </li> <li> <a
 * href="page_calendar.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/page_calendar.html">
 * <i class="fa fa-calendar"></i> <span class="badge badge-important"> 14
 * </span> Calendar </a> </li> </ul> </li> <li class=""> <a href="javascript:;">
 * <i class="fa fa-gift"></i> <span class="title"> Extra </span> <span
 * class="arrow"> </span> </a> <ul class="sub-menu" style="display: none;"> <li>
 * <a href="extra_profile.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/extra_profile.html">
 * User Profile </a> </li> <li> <a href="extra_lock.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/extra_lock.html">
 * Lock Screen </a> </li> <li> <a href="extra_faq.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/extra_faq.html"> FAQ
 * </a> </li> <li> <a href="inbox.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/inbox.html"> <span
 * class="badge badge-important"> 4 </span> Inbox </a> </li> <li> <a
 * href="extra_search.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/extra_search.html">
 * Search Results </a> </li> <li> <a href="extra_invoice.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/extra_invoice.html">
 * Invoice </a> </li> <li> <a href="extra_pricing_table.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/extra_pricing_table.html">
 * Pricing Tables </a> </li> <li> <a href="extra_404_option1.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/extra_404_option1.html">
 * 404 Page Option 1 </a> </li> <li> <a href="extra_404_option2.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/extra_404_option2.html">
 * 404 Page Option 2 </a> </li> <li> <a href="extra_404_option3.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/extra_404_option3.html">
 * 404 Page Option 3 </a> </li> <li> <a href="extra_500_option1.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/extra_500_option1.html">
 * 500 Page Option 1 </a> </li> <li> <a href="extra_500_option2.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/extra_500_option2.html">
 * 500 Page Option 2 </a> </li> </ul> </li> <li class=""> <a
 * href="javascript:;"> <i class="fa fa-folder-open"></i> <span class="title">
 * Multi Level Menu </span> <span class="arrow"> </span> </a>
 * <ul class="sub-menu" style="display: none;"> <li class="open"> <a
 * href="javascript:;"> <i class="fa fa-cogs"></i> Item 1 <span class="arrow
 * open"> </span> </a> <ul class="sub-menu" style="display: block;">
 * <li class="open"> <a href="javascript:;"> <i class="fa fa-user"></i> Sample
 * Link 1 <span class="arrow open"> </span> </a>
 * <ul class="sub-menu" style="display: block;"> <li> <a href="#"> <i class="fa
 * fa-remove"></i> Sample Link 1 </a> </li> <li> <a href="#"> <i class="fa
 * fa-pencil"></i> Sample Link 1 </a> </li> <li> <a href="#"> <i class="fa
 * fa-edit"></i> Sample Link 1 </a> </li> </ul> </li> <li> <a href="#"> <i
 * class="fa fa-user"></i> Sample Link 1 </a> </li> <li> <a href="#"> <i
 * class="fa fa-external-link"></i> Sample Link 2 </a> </li> <li> <a href="#">
 * <i class="fa fa-bell"></i> Sample Link 3 </a> </li> </ul> </li> <li> <a
 * href="javascript:;"> <i class="fa fa-globe"></i> Item 2 <span class="arrow">
 * </span> </a> <ul class="sub-menu"> <li> <a href="#"> <i class="fa fa-user"></i>
 * Sample Link 1 </a> </li> <li> <a href="#"> <i class="fa fa-external-link"></i>
 * Sample Link 1 </a> </li> <li> <a href="#"> <i class="fa fa-bell"></i> Sample
 * Link 1 </a> </li> </ul> </li> <li> <a href="#"> <i class="fa fa-folder-open"></i>
 * Item 3 </a> </li> </ul> </li> <li class=""> <a href="javascript:;"> <i
 * class="fa fa-user"></i> <span class="title"> Login Options </span> <span
 * class="arrow"> </span> </a> <ul class="sub-menu" style="display: none;"> <li>
 * <a href="login.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/login.html"> Login
 * Form 1 </a> </li> <li> <a href="login_soft.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/login_soft.html">
 * Login Form 2 </a> </li> </ul> </li> <li class=""> <a href="javascript:;"> <i
 * class="fa fa-th"></i> <span class="title"> Data Tables </span> <span
 * class="arrow"> </span> </a> <ul class="sub-menu" style="display: none;"> <li>
 * <a href="table_basic.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/table_basic.html">
 * Basic Datatables </a> </li> <li> <a href="table_responsive.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/table_responsive.html">
 * Responsive Datatables </a> </li> <li> <a href="table_managed.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/table_managed.html">
 * Managed Datatables </a> </li> <li> <a href="table_editable.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/table_editable.html">
 * Editable Datatables </a> </li> <li> <a href="table_advanced.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/table_advanced.html">
 * Advanced Datatables </a> </li> <li> <a href="table_ajax.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/table_ajax.html">
 * Ajax Datatables </a> </li> </ul> </li> <li class=""> <a href="javascript:;">
 * <i class="fa fa-file-text"></i> <span class="title"> Portlets </span> <span
 * class="arrow"> </span> </a> <ul class="sub-menu" style="display: none;"> <li>
 * <a href="portlet_general.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/portlet_general.html">
 * General Portlets </a> </li> <li> <a href="portlet_ajax.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/portlet_ajax.html">
 * Ajax Portlets </a> </li> <li> <a href="portlet_draggable.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/portlet_draggable.html">
 * Draggable Portlets </a> </li> </ul> </li> <li class=""> <a
 * href="javascript:;"> <i class="fa fa-map-marker"></i> <span class="title">
 * Maps </span> <span class="arrow"> </span> </a>
 * <ul class="sub-menu" style="display: none;"> <li> <a href="maps_google.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/maps_google.html">
 * Google Maps </a> </li> <li> <a href="maps_vector.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/maps_vector.html">
 * Vector Maps </a> </li> </ul> </li> <li class="last "> <a href="charts.html"
 * tppabs="http://www.keenthemes.com/preview/metronic_admin/charts.html"> <i
 * class="fa fa-bar-chart-o"></i> <span class="title"> Visual Charts </span>
 * </a> </li> </ul> <!-- END SIDEBAR MENU --> </div>
 */

