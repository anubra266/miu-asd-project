/**
 * Author: Bayarjargal Jargalsaikhan
 * Date:2024.05.21
 * Time:14:35
 */

package app.framework.rules;

public interface Rule<E, T>{

    boolean matches(E e, T t);
    void apply(E e, T t);

}
