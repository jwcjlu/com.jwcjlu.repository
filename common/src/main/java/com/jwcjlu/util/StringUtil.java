package com.jwcjlu.util;

import java.util.regex.Pattern;

/**
 * 
 * @ClassName: StringUtil
 * @Description: (�ַ���������)
 * @author ��ΰ
 * @date 2016��8��18�� ����1:48:40
 *
 */
public class StringUtil {
	/**
	 * �ַ�������ƥ�䷽��
	 * 
	 * @param string
	 *            Ҫƥ����ַ���
	 * @param regex
	 *            ������ʽ
	 * @return
	 */
	public static boolean stringFilter(String string, String regex) {
		Pattern p = Pattern.compile(regex);
		return p.matcher(string).matches();
	}

	/**
	 * У���Ƿ����ֻ���
	 * 
	 * @param phone
	 *            �ֻ���
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
	 * У���Ƿ������֤
	 * 
	 * @param card
	 *            ���֤��
	 * @return
	 */
	public static boolean isCard(String card) {
		if (isEmpty(card)) {
			return false;
		}
		String regex15 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";// 15λ���֤��������ʽ
		String regex18 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";// 18λ���֤��������ʽ
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
	 * �ж��ַ����Ƿ�Ϊ��
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
	 * �ж��ַ�����Ϊ��
	 * 
	 * @param text
	 * @return
	 */

	public static boolean notEmpty(String text) {
		return !isEmpty(text);
	}
}
