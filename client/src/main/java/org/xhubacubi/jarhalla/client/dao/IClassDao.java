/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package org.xhubacubi.jarhalla.client.dao;

import java.util.List;
import org.xhubacubi.jarhalla.client.dao.bean.Clazz;

/**
 *
 * @author rugi
 */
public interface IClassDao {

    public boolean addClass(String idRepo,String pathJar ,String nameJar, String clazz);
    public boolean addClass(String idRepo,String pathJar , String nameJar, List<String> items);

    public boolean deleteClassByPathAndNameJar(String idRepo, String nameJar);

    public List<Clazz> getListClassByIdRepoAndLike(String idRepo, String like);
}