package com.adifier.form;

/**
 * convert form Source to Transform
 * @param <S>
 * @param <T>
 */
public interface FormConvert<S,T> {

    T convert(S s);

}
