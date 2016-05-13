package org.varelma.oc.util;

import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 * Comparator to do sorting <code>comparator</code>.
 * 
 * It works with complex object using dot notation
 * example 
 * 
 * Note when working with ATG List,Sets and Maps
 * when they are retrieved form the repository then they are 
 * ChangeAware this means that if you sort then you change the 
 * order in the DB!!!!
 *  
 * To get around this simple disconnect the items form the List
 * <code>
 * 	List<RepositoryItem> result  = new ArrayList<RepositoryItem>();
 *	result.addAll(dataToSort)
 *  // now sort it 
 *  ComparableComparator comparableComparator = new ComparableComparator("a.b.c");
 *  Collections.sort(result, comparableComparator);
 * 
 * </code>
 * @author jon pallas
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ComparableComparator implements Comparator, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5023490333206857810L;
	/**
	 * The property to compare.
	 */
	protected String property;

	/**
	 * The current users locale
	 */
	protected Locale locale = (Locale) ComponentResolver.getComponent("/atg/service/localeservice/LocaleService.locale");

	public ComparableComparator(String compareProperty) {
		property = compareProperty;
	}

	/**
	 * Compare two objects, by comparable items as specified by the constructor, compared by the property as specified in the constructor. Test for a class cast exception and ignore it - any problems during conparison result in neutral (ie 0) result.
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */

	public int compare(Object first, Object second) {
		Comparable inValue = (Comparable) BeanUtils.getNestedProperty(first, property);
		Comparable outValue = (Comparable) BeanUtils.getNestedProperty(second, property);

		if (inValue instanceof String && outValue instanceof String) {
			return stringCompare((String) inValue, (String) outValue);
		}

		if (inValue == null) {
			return outValue == null ? 0 : -1;
		}
		if (outValue == null) {
			return 1;
		}
		return inValue.compareTo(outValue);
	}

	private int stringCompare(String first, String second) {
		Collator collator = Collator.getInstance(locale);
		collator.setStrength(Collator.SECONDARY);
		return collator.compare(first, second);
	}

}