/**
 * 
 */
package emartscan.emart.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emartscan.emart.com.model.Device;

/**
 * @author hj.kim khj20825@gmail.com
 * @since 2019. 11. 25.
 *
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {

}
