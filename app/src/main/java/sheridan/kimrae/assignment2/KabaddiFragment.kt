package sheridan.kimrae.assignment2

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import sheridan.kimrae.assignment2.databinding.FragmentKabaddiBinding

class KabaddiFragment : Fragment(), MenuProvider {
    private var _binding: FragmentKabaddiBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentKabaddiBinding.inflate(inflater, container, false)

        // set up fragment menu
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.resetButton.setOnClickListener {
            findNavController().navigate(R.id.action_kabaddiFragment_to_historyFragment)


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_kabaddi, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId) {
            R.id.action_history -> {
                //findNavController().navigate(NavGraphDirections.actionGlobalHistoryFragment())
                findNavController().navigate(R.id.action_kabaddiFragment_to_historyFragment)
                true
            }
            else -> false
        }
    }
}