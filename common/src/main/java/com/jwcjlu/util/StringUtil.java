package com.jwcjlu.util;

import java.util.regex.Pattern;

/**
 * 
 * @ClassName: StringUtil
 * @Description: (字符串工具类)
 * @author 金伟
 * @date 2016年8月18日 下午1:48:40
 *
 */
public class StringUtil {
	/**
	 * 字符串正则匹配方法
	 * 
	 * @param string
	 *            要匹配的字符串
	 * @param regex
	 *            正则表达式
	 * @return
	 */
	public static boolean stringFilter(String string, String regex) {
		Pattern p = Pattern.compile(regex);
		return p.matcher(string).matches();
	}

	/**
	 * 校验是否是手机号
	 * 
	 * @param phone
	 *            手机号
	 * @return
	 */
	public static boolean isPhone(String phone) {
		if (isEmpty(phone)) {
			return false;
		}
		String regex = " ^((13\\d{9}$)|(15[0,1,2,3,5,6,7,8,9]\\d{8}$)|(18[0,2,5,6,7,8,9]\\d{8}$)|(14\\d{9})$)";
		return matcher(phone, regex);
	}

	/**
	 * 校验是否是身份证
	 * 
	 * @param card
	 *            身份证号
	 * @return
	 */
	public static boolean isCard(String card) {
		if (isEmpty(card)) {
			return false;
		}
		String regex15 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";// 15位身份证的正则表达式
		String regex18 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";// 18位身份证的正则表达式
		boolean flag = matcher(card, regex15);
		if (!flag) {
			flag = matcher(card, regex18);
		}
		return flag;
	}

	public static boolean matchers(String text, String[] regexs) {
		boolean flag = false;
		if (regexs == null) {
			return flag;
		}
		for (String regex : regexs) {
			if (isEmpty(regex)) {
				continue;
			}
			flag = matcher(text, regex);
			if (flag) {
				break;
			}
		}
		return flag;
	}

	public static boolean matcher(String text, String regex) {
		Pattern pattern = Pattern.compile(regex);
		if (pattern.matcher(text).matches()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isEmpty(String text) {
		if (null == text) {
			return true;
		}
		return text.isEmpty();
	}

	/**
	 * 判断字符串不为空
	 * 
	 * @param text
	 * @return
	 */

	public static boolean notEmpty(String text) {
		return !isEmpty(text);
	}
}
