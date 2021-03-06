package fincaV1.server.servicegeneric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fincaV1.server.daogeneric.GenericDao;
import fincaV1.server.daogeneric.GenericDaoImp;
import fincaV1.server.test.TestDao;

@Service
public class GenericServiceImp {
		@Autowired
		private GenericDaoImp genericDao;
		
		@Transactional
		public <T> T getAll(final Class<T> type) {
			return genericDao.getAll(type);
		}

		@Transactional
		public <T> T get(final Class<T> type, final int id) {
			return genericDao.get(type, id);
		}

		@Transactional
		public <T> String saveOrUpdate(final T o) {
			return genericDao.saveOrUpdate(o);
		}
		
		@Transactional
		public <T> String delete(final T o) {
			return genericDao.delete(o);
		}
		
		@Transactional
	    public <T> int save(final T o){
	       return genericDao.save(o);
	      }

}
