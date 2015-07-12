/**
 * TimeUtil
 */

(function($){
	
	// 对Date的扩展，将 Date 转化为指定格式的String
	// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
	// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
	// 例子： 
	// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
	// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
	$.fn.TimeUtil.format = 	
		Date.prototype.Format = function (fmt) { //author: meizz 
		    var o = {
		        "M+": this.getMonth() + 1, //月份 
		        "d+": this.getDate(), //日 
		        "h+": this.getHours(), //小时 
		        "m+": this.getMinutes(), //分 
		        "s+": this.getSeconds(), //秒 
		        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
		        "S": this.getMilliseconds() //毫秒 
		    };
		    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
		    for (var k in o)
		    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		    return fmt;
		};
	
	$.fn.TimeUtil.today = function(){
			
			
	}
	
	$.fn.TimeUtil.thisMonth = function(){
		
		
	}
	
	
	$.fn.TimeUtil.thisYear = function(){
		
		
	}
	
	$.fn.TimeUtil.thisWeek = function(){
		
		
	}
	
	
	
	
})(window);


var TimeUtil = function(){
	
	// 对Date的扩展，将 Date 转化为指定格式的String
	// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
	// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
	// 例子： 
	// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
	// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	};
	//调用： var time1 = new Date().Format("yyyy-MM-dd");var time2 = new Date().Format("yyyy-MM-dd HH:mm:ss");
	var dayMils = 24*60*60*1000;
	var hourMils = 60*60*1000;
	var minuteMils = 60*1000;
	
	/**
	 * 获取指定月的天数
	 */
	function getDaysNumOfMonth(mm){
		
		var date  = new Date();
		var year = date.getFullYear();
		var isLeapYear =  (year%4 == 0 && year%100 != 0 || year%400 == 0 && year%100 != 0); 
		var dayOfMonth = 30;
		switch(mm){
			case 1:dayOfMonth = 31;break;
			case 2: dayOfMonth = isLeapYear? 29:28;break;
			case 3:dayOfMonth = 31;break;
			case 4:dayOfMonth = 30;break;
			case 5:dayOfMonth = 31;break;
			case 6:dayOfMonth = 30;break;
			case 7:dayOfMonth = 31;break;
			case 8:dayOfMonth = 31;break;
			case 9:dayOfMonth = 30;break;
			case 10:dayOfMonth = 31;break;
			case 11:dayOfMonth = 30;break;
			case 12:dayOfMonth = 31;break;
		}
		
		return dayOfMonth;
		
	}
	
	/**
	 * 格式化输出时间格式
	 * @author Thinkpad
	 * @param date 时间
	 * @param format 格式
	 */
	function format(date , format){
		return date.Format(format);
	}
	
	function getDate(){
		
	}
	
	/**
	 * 时间添加n个单位
	 * @param field yyyy,MM,dd HH,mm,ss
	 * @param n 添加单位
	 */
	function add(field,n){
		
	}
	
	function setTime(){
		d.setTime(new Date().valueOf()-365*24*60*60*1000);
	}
	
	/**
	 * 获取过去30天
	 */
	function getLast30Days(date,format){
		var tempDate = new Date();
		tempDate.setTime(date.valueOf() - 30*dayMils);
		var dateArr = [];
		for(var i = 0;i < 30 ;i++){
			dateArr.push(tempDate.format(format));
			tempDate.setTime(date.valueOf() + dayMils);
		}
		return dateArr;
	}
	
	/**
	 * 获取过去30天
	 */
	function getLast30DaysStr(){
		var dateArr = getLast30Days(date,format);
		var sb = new StringBuffer();
		for(var i = 0 ; i < dateArr.length ; i++ ){
			sb.append(dateArr[i]);
			if(i+1<dateArr.length){
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 获取过去7天
	 */
	function getLast7Days(date,format){
		var tempDate = new Date();
		tempDate.setTime(date.valueOf() - 7*dayMils);
		var dateArr = [];
		for(var i = 0;i < 7 ;i++){
			dateArr.push(tempDate.format(format));
			tempDate.setTime(date.valueOf() + dayMils);
		}
		return dateArr;
	}
	
	/**
	 * 获取过去7天字符串 格式：
	 */
	function getLast7DaysStr(date,format){
		var dateArr = getLast7Days(date,format);
		var sb = new StringBuffer();
		for(var i = 0 ; i < dateArr.length ; i++ ){
			sb.append(dateArr[i]);
			if(i+1<dateArr.length){
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 获取过去24小时
	 */
	function getLast24Hours(){
		
	}
	
};


function StringBuffer(){
    this._Strings = new Array();
}
StringBuffer.prototype = {
    append : function(str){
        this._Strings.push(str);
    },
    toString : function(){
        return this._Strings.join(",");
    }
}


